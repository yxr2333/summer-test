package com.sheep.summertest.service;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.entity.User;
import com.sheep.summertest.vo.ResetPwdVO;
import com.sheep.summertest.vo.UserLoginVO;
import com.sheep.summertest.vo.UserRegisterVO;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service
 * @datetime 2022/8/18 星期四
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param vo 登录参数
     * @return 请求结果
     */
    ApiResult doLogin(UserLoginVO vo);

    /**
     * 删除用户
     *
     * @param uid 用户id
     * @return 删除结果
     */
    ApiResult deleteOne(Integer uid);

    /**
     * 获取所有用户
     *
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 请求结果
     */
    ApiResult findAll(Integer pageNum, Integer pageSize);


    /**
     * 更新用户
     *
     * @param user 更新后的用户信息
     * @return 请求结果
     */
    ApiResult updateOne(User user);

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return 请求结果
     */
    ApiResult findOne(Integer id);

    /**
     * 添加用户
     *
     * @param vo 用户注册信息
     * @return 请求结果
     */
    ApiResult addOne(UserRegisterVO vo);

    /**
     * 查询用户的购买历史
     *
     * @param uid      用户id
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 请求结果
     */
    ApiResult getBuyHistory(Integer uid, Integer pageNum, Integer pageSize);

    /**
     * 重置密码
     *
     * @param vo 密码信息
     * @return 请求结果
     */
    ApiResult resetPassword(ResetPwdVO vo);
}
