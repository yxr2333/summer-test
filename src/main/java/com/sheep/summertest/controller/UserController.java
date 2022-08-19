package com.sheep.summertest.controller;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.entity.User;
import com.sheep.summertest.service.UserService;
import com.sheep.summertest.vo.ResetPwdVO;
import com.sheep.summertest.vo.UserLoginVO;
import com.sheep.summertest.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/17 星期三
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ApiResult doLogin(@RequestBody UserLoginVO vo) {
        return userService.doLogin(vo);
    }

    /*
    查询：Get
    添加：Post
    删除：Delete
    更新：Put
     */

    @DeleteMapping("/{id}")
    public ApiResult deleteOne(@PathVariable Integer id) {
        return userService.deleteOne(id);
    }

    @GetMapping("/all")
    public ApiResult findAll(Integer pageNum, Integer pageSize) {
        return userService.findAll(pageNum, pageSize);
    }

    @PutMapping("")
    public ApiResult updateOne(@RequestBody User user) {
        return userService.updateOne(user);
    }

    @GetMapping("/one/{id}")
    public ApiResult findOne(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @PostMapping("")
    public ApiResult addOne(@RequestBody UserRegisterVO vo) {
        return userService.addOne(vo);
    }

    @GetMapping("/buy/history")
    public ApiResult findBuyHistory(
            @RequestParam(required = false) Integer uid,
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize) {
        if (uid == null) {
            return ApiResult.error("用户id不能为空");
        }
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        return userService.getBuyHistory(uid, pageNum, pageSize);
    }

    @PostMapping("/resetpwd")
    public ApiResult resetPassword(HttpServletRequest request, @RequestBody ResetPwdVO vo) {
        return userService.resetPassword(request, vo);
    }


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
