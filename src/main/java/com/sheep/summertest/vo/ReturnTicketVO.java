package com.sheep.summertest.vo;

import lombok.Data;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.vo
 * @datetime 2022/8/19 星期五
 */
@Data
public class ReturnTicketVO {

    private Integer orderId;

    private Integer returnerId;

    private Integer movieSessionId;
}
