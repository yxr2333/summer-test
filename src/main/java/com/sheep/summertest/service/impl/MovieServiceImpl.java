package com.sheep.summertest.service.impl;

import com.sheep.summertest.dao.MovieDao;
import com.sheep.summertest.dao.MovieSessionDao;
import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.dto.MovieSessionDTO;
import com.sheep.summertest.entity.Movie;
import com.sheep.summertest.entity.MovieSession;
import com.sheep.summertest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service.impl
 * @datetime 2022/8/18 星期四
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private MovieSessionDao movieSessionDao;

    /**
     * 查询所有电影信息
     *
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 查询结果
     */
    @Override
    public ApiResult findAll(Integer pageNum, Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        Page<Movie> movies = movieDao.findAll(pageable);
        return ApiResult.success(movies);
    }

    /**
     * 根据电影编号查询电影信息
     *
     * @param id 电影编号
     * @return 查询结果
     */
    @Override
    public ApiResult findOne(Integer id) {
        // lambda
        Movie movie = movieDao.findById(id).orElseThrow(() -> new RuntimeException("编号对应信息不存在"));
        return ApiResult.success(movie);
    }

    /**
     * 获取电影的所有场次信息
     *
     * @param id 电影编号
     * @return 查询结果
     */
    @Override
    public ApiResult getSessionsByMovieId(Integer id) {
        if (!movieDao.existsById(id)) {
            throw new RuntimeException("不存在的电影编号");
        }
        List<MovieSession> sessions = movieSessionDao.getAllByMovieId(id);
        if (CollectionUtils.isEmpty(sessions)) {
            throw new RuntimeException("该电影今日暂未排场");
        }
        List<MovieSessionDTO> result = sessions.stream().map(session -> {
            MovieSessionDTO movieSessionDTO = new MovieSessionDTO();
            movieSessionDTO.setId(session.getId());
            movieSessionDTO.setPrice(session.getPrice());
            movieSessionDTO.setStartTime(session.getStartTime());
            movieSessionDTO.setVotes(session.getVotes());
            return movieSessionDTO;
        }).collect(Collectors.toList());
        return ApiResult.success(result);
    }
}
