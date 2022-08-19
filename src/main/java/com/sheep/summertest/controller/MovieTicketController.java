package com.sheep.summertest.controller;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.service.MovieTicketService;
import com.sheep.summertest.vo.BuyTicketVO;
import com.sheep.summertest.vo.ReturnTicketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/19 星期五
 */
@RestController
@RequestMapping("/ticket")
public class MovieTicketController {

    @Autowired
    private MovieTicketService ticketService;


    @PostMapping("/buy")
    public ApiResult buyTicket(@RequestBody BuyTicketVO vo) {
        return ticketService.buyTicket(vo);
    }

    @PostMapping("/ret")
    public ApiResult returnTicket(@RequestBody ReturnTicketVO vo) {
        return ticketService.returnTicket(vo);
    }
}
