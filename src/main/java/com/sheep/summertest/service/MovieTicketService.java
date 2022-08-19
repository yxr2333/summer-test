package com.sheep.summertest.service;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.vo.BuyTicketVO;
import com.sheep.summertest.vo.ReturnTicketVO;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service
 * @datetime 2022/8/19 星期五
 */
public interface MovieTicketService {

    ApiResult buyTicket(BuyTicketVO vo);

    ApiResult returnTicket(ReturnTicketVO vo);
}
