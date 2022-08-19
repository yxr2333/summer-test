package com.sheep.summertest.service.impl;

import com.sheep.summertest.dao.MovieDao;
import com.sheep.summertest.dao.MovieSessionDao;
import com.sheep.summertest.dao.MovieTicketDao;
import com.sheep.summertest.dao.UserDao;
import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.entity.Movie;
import com.sheep.summertest.entity.MovieSession;
import com.sheep.summertest.entity.MovieTicket;
import com.sheep.summertest.entity.User;
import com.sheep.summertest.service.MovieTicketService;
import com.sheep.summertest.vo.BuyTicketVO;
import com.sheep.summertest.vo.ReturnTicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service.impl
 * @datetime 2022/8/19 星期五
 */
@Service
@RequiredArgsConstructor
public class MovieTicketServiceImpl implements MovieTicketService {


    final UserDao userDao;
    final MovieDao movieDao;
    final MovieSessionDao movieSessionDao;
    final MovieTicketDao movieTicketDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResult buyTicket(BuyTicketVO vo) {
        MovieSession movieSession = movieSessionDao.findById(vo.getMovieSessionId())
                .orElseThrow(() -> new RuntimeException("不存在此场次编号"));
        if (movieSession.getVotes() <= 0) {
            throw new RuntimeException("该场次的电影票已经卖完了，购票失败");
        }
        if (!movieSession.getMovie().getId().equals(vo.getMovieId())) {
            throw new RuntimeException("场次和电影信息不匹配，购买失败");
        }
        Movie movie = movieDao.findById(vo.getMovieId())
                .orElseThrow(() -> new RuntimeException("不存在此电影信息"));
        User buyer = userDao.findById(vo.getBuyerId())
                .orElseThrow(() -> new RuntimeException("不存在此用户的信息"));
        synchronized (this) {
            movieSessionDao.sellTicket(vo.getMovieSessionId());
        }
        MovieTicket ticket = new MovieTicket();
        ticket.setMovie(movie);
        ticket.setName(movie.getName());
        ticket.setBuyer(buyer);
        ticket.setCinema(vo.getCinema());
        ticket.setStartTime(vo.getStartTime());
        ticket.setPrice(vo.getPrice());
        movieTicketDao.save(ticket);
        return ApiResult.success("购票成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResult returnTicket(ReturnTicketVO vo) {
        if (!movieSessionDao.existsById(vo.getMovieSessionId())) {
            throw new RuntimeException("不存在的场次编号");
        }
        MovieTicket ticket = movieTicketDao.findById(vo.getOrderId())
                .orElseThrow(() -> new RuntimeException("不存在的票据信息"));
        if (!ticket.getBuyer().getUid().equals(vo.getReturnerId())) {
            throw new RuntimeException("该票不是您购买，无法退票");
        }
        synchronized (this) {
            movieSessionDao.returnTicket(vo.getMovieSessionId());
        }
        movieTicketDao.deleteById(vo.getOrderId());
        return ApiResult.success("退票成功");
    }
}
