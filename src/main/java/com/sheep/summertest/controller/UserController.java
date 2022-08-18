package com.sheep.summertest.controller;

import com.sheep.summertest.dao.UserDao;
import com.sheep.summertest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/17 星期三
 */
@RestController
public class UserController {

    // Bean注入
    @Autowired
    private UserDao userDao;

    @GetMapping("/doLogin")
    public String doLogin(Integer uid, String password) {
        // 参数校验
        Optional<User> optionalUser = userDao.findById(uid);
        if (!optionalUser.isPresent()) {
            return "不存在此编号对应的用户";
        }
        // 查出数据库里面的数据
        User user = optionalUser.get();

        // 业务逻辑代码
        if (user.getPassword().equals(password)) {
            // 结果返回
            return "登录成功";
        } else {
            return "登录失败";
        }
    }
}
