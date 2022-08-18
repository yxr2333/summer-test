package com.sheep.summertest.service.impl;

import com.sheep.summertest.dao.MovieDao;
import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.entity.Movie;
import com.sheep.summertest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.service.impl
 * @datetime 2022/8/18 星期四
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public ApiResult findAll() {
        List<Movie> data = movieDao.findAll();
        return ApiResult.success(data);
    }

    @Override
    public ApiResult findOne(Integer id) {
        Movie movie = movieDao.getById(id);
        return ApiResult.success(movie);
    }
}
