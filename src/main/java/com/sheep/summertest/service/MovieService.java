package com.sheep.summertest.service;

import com.sheep.summertest.dto.ApiResult;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service
 * @datetime 2022/8/18 星期四
 */
public interface MovieService {

    // 业务代码
    ApiResult findAll();

    ApiResult findOne(Integer id);

}
