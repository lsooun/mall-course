package com.lsooun.mall.exception;

import com.lsooun.mall.common.api.CommonResult;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ParamValidationHandler {
    @ExceptionHandler(BindException.class)
    public CommonResult bindException(BindException e) {
        BindingResult result = e.getBindingResult();

        return CommonResult.validateFailed(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult bindException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        return CommonResult.validateFailed(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult requestBodyMissingException(HttpMessageNotReadableException e) {
        return CommonResult.failed("请求体不能为空");
    }
}
