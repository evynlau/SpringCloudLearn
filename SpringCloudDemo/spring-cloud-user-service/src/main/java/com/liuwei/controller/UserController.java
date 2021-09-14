package com.liuwei.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/14 13:51
 * @Package: com.liuwei.controller
 * @Modified By：
 * @Description：
 */
@Api(tags = "用户信息管理")
@RestController
public class UserController {

    @ApiOperation("获取用户信息")
    @GetMapping("/user")
    public String user(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getHeader("user_id"));
        return request.getHeader("user_id");
    }
}
