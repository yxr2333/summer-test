package com.sheep.summertest.controller;

import com.sheep.summertest.dto.ApiResult;
import com.sheep.summertest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.controller
 * @datetime 2022/8/18 星期四
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ApiResult getAll(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        return movieService.findAll(pageNum, pageSize);
    }

    @GetMapping("/one/{id}")
    public ApiResult getById(@PathVariable Integer id) {
        if (id == null) {
            return ApiResult.error("请输入编号");
        }
        return movieService.findOne(id);
    }

    @GetMapping("/session/all")
    public ApiResult getSessionsByMovieId(@RequestParam(required = false) Integer id) {
        if (id == null) {
            return ApiResult.error("请输入电影编号");
        }
        return movieService.getSessionsByMovieId(id);
    }
}
