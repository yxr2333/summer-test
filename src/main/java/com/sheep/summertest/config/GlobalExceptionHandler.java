package com.sheep.summertest.config;

import com.sheep.summertest.dto.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created By Intellij IDEA
 *
 * @author ssssheep
 * @package com.sheep.summertest.config
 * @datetime 2022/8/18 星期四
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ApiResult handleException(Exception e) {
        ApiResult result = null;
        if (e instanceof RuntimeException) {
            RuntimeException runtimeException = (RuntimeException) e;
            result = ApiResult.error(runtimeException.getMessage());
        }
        return result;
    }
}
