package com.jonas.one.service;


import com.jonas.one.model.AuthQuery;
import com.jonas.one.model.User;

public interface AuthService {

    User auth(AuthQuery query);

}
