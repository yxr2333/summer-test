package com.sheep.summertest.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailUtil;
import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.service.CommonService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service.impl
 * @datetime 2022/8/19 星期五
 */
@Service
public class CommonServiceImpl implements CommonService {
    /**
     * 发送验证码
     *
     * @param request 请求对象
     * @param email   收件人邮箱
     * @return 响应结果
     */
    @Override
    public ApiResult sendResetPwdCode(HttpServletRequest request, String email) {
        String code = RandomUtil.randomString(5);
        request.getSession().setAttribute("verify_code", code);
        String content = "您正在重设验证码，验证码为：" + code + "，请妥善保存";
        MailUtil.send(email, "重设验证码中...", content, false);
        return ApiResult.success("发送成功");
    }
}
