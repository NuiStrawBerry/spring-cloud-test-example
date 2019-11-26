package com.jonas.one.web;

import com.jonas.one.common.ResponseData;
import com.jonas.one.model.AuthQuery;
import com.jonas.one.model.User;
import com.jonas.one.service.AuthService;
import com.jonas.one.util.JWTUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private AuthService authService;


    @GetMapping("/health")
    public String hello() {
        return "OK";
    }

    @PostMapping("/token")
    public ResponseData auth(@RequestBody AuthQuery query) throws Exception {
        if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
            return ResponseData.failByParam("accessKey and secretKey not null");
        }

        User user = authService.auth(query);
        if (user == null) {
            return ResponseData.failByParam("认证失败");
        }

        JWTUtils jwt = JWTUtils.getInstance();
        return ResponseData.ok(jwt.getToken(user.getId().toString()));
    }


    @GetMapping("/token")
    public ResponseData oauth(AuthQuery query) throws Exception {
        if (StringUtils.isBlank(query.getAccessKey()) || StringUtils.isBlank(query.getSecretKey())) {
            return ResponseData.failByParam("accessKey and secretKey not null");
        }

        User user = authService.auth(query);
        if (user == null) {
            return ResponseData.failByParam("认证失败");
        }

        JWTUtils jwt = JWTUtils.getInstance();
        return ResponseData.ok(jwt.getToken(user.getId().toString()));
    }
}
