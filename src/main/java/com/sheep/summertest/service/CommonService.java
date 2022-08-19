package com.sheep.summertest.service;

import com.sheep.summertest.dto.ApiResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service
 * @datetime 2022/8/19 星期五
 */
public interface CommonService {

    /**
     * 发送验证码
     *
     * @param request 请求对象
     * @param email   收件人邮箱
     * @return 响应结果
     */
    ApiResult sendResetPwdCode(HttpServletRequest request, String email);
}
