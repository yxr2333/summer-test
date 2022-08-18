package com.sheep.summertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/17 星期三
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello,World";
    }

    // 用户登录

    @PostMapping("/login")
    public String login(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        if ("root".equals(username) && "root".equals(password)) {
            return "success";
        } else {
            return "error";
        }
    }

}
