package com.jonas.one.service.impl;

import com.jonas.one.mapper.UserMapper;
import com.jonas.one.model.AuthQuery;
import com.jonas.one.model.User;
import com.jonas.one.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired

    private UserMapper userMapper;
    @Override
    public User auth(AuthQuery query) {
       String id =  userMapper.getPasswordByUserId(query);
        return new User(Long.valueOf(id));
    }

}
