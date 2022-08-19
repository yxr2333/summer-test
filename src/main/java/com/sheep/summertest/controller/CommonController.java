package com.sheep.summertest.controller;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/19 星期五
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/sendCode")
    public ApiResult sendResetPwdCode(
            HttpServletRequest request,
            @RequestParam(required = false) String email) {
        if (email == null) {
            return ApiResult.error("请输入收件人邮箱");
        }
        return commonService.sendResetPwdCode(request, email);
    }
}
