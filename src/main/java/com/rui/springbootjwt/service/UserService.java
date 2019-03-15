package com.rui.springbootjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rui.springbootjwt.vo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30000)) // 设置token的过期时间
                .sign(Algorithm.HMAC256(user.getPasswd()));
        return token;
    }
}
