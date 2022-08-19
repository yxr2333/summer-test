package com.sheep.summertest.service;

import com.sheep.summertest.dto.ApiResult;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service
 * @datetime 2022/8/18 星期四
 */
public interface MovieService {

    /**
     * 查询所有电影信息
     *
     * @param pageNum  页码
     * @param pageSize 页容量
     * @return 查询结果
     */
    ApiResult findAll(Integer pageNum, Integer pageSize);


    /**
     * 根据电影编号查询电影信息
     *
     * @param id 电影编号
     * @return 查询结果
     */
    ApiResult findOne(Integer id);

    /**
     * 获取电影的所有场次信息
     *
     * @param id 电影编号
     * @return 查询结果
     */
    ApiResult getSessionsByMovieId(Integer id);

}
