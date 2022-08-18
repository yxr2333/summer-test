package com.sheep.summertest.controller;

import com.sheep.summertest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/17 星期三
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


//    // Bean注入
//    @Autowired
//    private UserDao userDao;
//
//    @GetMapping("/doLogin")
//    public String doLogin(Integer uid, String password) {
////        // 参数校验
////        Optional<User> optionalUser = userDao.findById(uid);
////        if (!optionalUser.isPresent()) {
////            return "不存在此编号对应的用户";
////        }
////        // 查出数据库里面的数据
////        User user = optionalUser.get();
////
////        // 业务逻辑代码
////        if (user.getPassword().equals(password)) {
////            // 结果返回
////            return "登录成功";
////        } else {
////            return "登录失败";
////        }
//        return null;
//    }
//
//    @PostMapping("/regis")
//    public String doRegister(@RequestBody User user) {
//        System.out.println(user);
//        return "hello";
//    }
//
//    // 通过用户的编号，查询用户的信息
//    // 从路径接受参数
//    @GetMapping("/get/{id}")
//    public User findUserById(@PathVariable Integer id) {
//        Optional<User> optionalUser = userDao.findById(id);
//        // 检测是否有数据
//        if (!optionalUser.isPresent()) {
//            return null;
//        }
//        // 有数据
//        return optionalUser.get();
//    }
}
