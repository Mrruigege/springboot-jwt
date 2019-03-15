package com.rui.springbootjwt.controller;

import com.rui.springbootjwt.annotation.UserLogToken;
import com.rui.springbootjwt.service.UserService;
import com.rui.springbootjwt.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  这里为了方便起见，并没有引入数据库，所有就认证一个id为1，密码为aa123456的用户
 */
@RestController
public class UserAPI {
    @Autowired
    UserService userService;
    @PostMapping("/log")
    // httpRequest无法通过post请求拿到参数，所以这里用@RequestBody去取参数
    public String log(@RequestBody User user) {

        if (!user.getId().equals("1")) {
            return "用户不存在";
        } else if (!user.getPasswd().equals("aa123456")) {
            return "密码错误";
        } else {
            String token = userService.getToken(user);
            return token;
        }
    }
    @UserLogToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
