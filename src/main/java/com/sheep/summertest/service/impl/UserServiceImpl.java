package com.sheep.summertest.service.impl;

import com.sheep.summertest.dao.MovieTicketDao;
import com.sheep.summertest.dao.UserDao;
import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.entity.MovieTicket;
import com.sheep.summertest.entity.User;
import com.sheep.summertest.service.UserService;
import com.sheep.summertest.vo.ResetPwdVO;
import com.sheep.summertest.vo.UserLoginVO;
import com.sheep.summertest.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service.impl
 * @datetime 2022/8/18 星期四
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MovieTicketDao movieTicketDao;

    /**
     * 用户登录
     *
     * @param vo 登录参数
     * @return 请求结果
     */
    @Override
    public ApiResult doLogin(UserLoginVO vo) {
        Optional<User> optionalUser = userDao.findByName(vo.getUsername());
        if (!optionalUser.isPresent()) {
            return ApiResult.error("用户不存在");
        }
        User user = optionalUser.get();
        if (user.getPwd().equals(vo.getPassword())) {
            return ApiResult.success("登录成功");
        } else {
            return ApiResult.error("密码错误");
        }
    }

    /**
     * 删除用户
     *
     * @param uid 用户id
     * @return 删除结果
     */
    @Override
    public ApiResult deleteOne(Integer uid) {
        if (!userDao.existsById(uid)) {
            return ApiResult.error("用户不存在");
        }
        userDao.deleteById(uid);
        return ApiResult.success("删除成功");
    }

    /**
     * 获取所有用户
     *
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 请求结果
     */
    @Override
    public ApiResult findAll(Integer pageNum, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "uid");
        PageRequest pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return ApiResult.success(userDao.findAll(pageable));
    }

    /**
     * 查询用户的购买历史
     *
     * @param uid      用户id
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 请求结果
     */
    @Override
    public ApiResult getBuyHistory(Integer uid, Integer pageNum, Integer pageSize) {
        if (!userDao.existsById(uid)) {
            return ApiResult.error("用户不存在");
        }
        PageRequest pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<MovieTicket> page = movieTicketDao.findAllByBuyerUid(uid, pageable);
        return ApiResult.success(page.getContent());
    }

    /**
     * 更新用户
     *
     * @param user 更新后的用户信息
     * @return 请求结果
     */
    @Override
    public ApiResult updateOne(User user) {
        userDao.save(user);
        return ApiResult.success("更新成功");
    }

    /**
     * 添加用户
     *
     * @param vo 用户注册信息
     * @return 请求结果
     */
    @Override
    public ApiResult addOne(UserRegisterVO vo) {
        if (userDao.existsByName(vo.getUsername())) {
            throw new RuntimeException("用户名已存在");
        }
        User user = new User();
        user.setName(vo.getUsername());
        user.setPwd(vo.getPassword());
        user.setMailBox(vo.getMailBox());
        userDao.save(user);
        return ApiResult.success("添加成功");
    }

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return 请求结果
     */
    @Override
    public ApiResult findOne(Integer id) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("用户不存在"));
        return ApiResult.success("查询成功", user);
    }

    /**
     * 重置密码
     *
     * @param request 请求
     * @param vo      密码信息
     * @return 请求结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResult resetPassword(HttpServletRequest request, ResetPwdVO vo) {
        HttpSession session = request.getSession();
        String code = session.getAttribute("verify_code").toString();
        if (code.equals(vo.getVerifyCode())) {
            User user = userDao.findByName(vo.getUsername()).orElseThrow(() -> new RuntimeException("用户不存在"));
            user.setPwd(vo.getNewPwd());
            userDao.save(user);
            return ApiResult.success("重置成功");
        } else {
            return ApiResult.error("验证码错误");
        }
    }
}
