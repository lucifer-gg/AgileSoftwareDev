package com.example.AgileBackEnd.handler;

import com.example.AgileBackEnd.entity.vo.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response doException(Exception ex){
        ex.printStackTrace();
        return Response.fail(-999,"系统异常");
    }

}
