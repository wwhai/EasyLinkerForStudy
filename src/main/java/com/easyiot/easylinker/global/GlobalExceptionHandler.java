package com.easyiot.easylinker.global;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常处理
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JSONObject handleIOException(Exception e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("error", e.getMessage());
        return jsonObject;
    }
}
