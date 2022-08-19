package com.sheep.summertest;

import cn.hutool.extra.mail.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SummerTestApplicationTests {

    @Test
    void contextLoads() {
        MailUtil.send("54535282@qq.com", "测试", "邮件来自Hutool测试", false);
    }

}
