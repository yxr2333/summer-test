package com.sheep.summertest.controller;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/18 星期四
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie/all")
    public ApiResult getAll() {
        return movieService.findAll();
    }

    @GetMapping("/movie/one/{id}")
    public ApiResult getById(@PathVariable Integer id) {
        return movieService.findOne(id);
    }
}
