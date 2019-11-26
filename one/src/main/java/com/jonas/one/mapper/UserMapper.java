package com.jonas.one.mapper;

import com.jonas.one.model.AuthQuery;

public interface UserMapper {
    String getPasswordByUserId(AuthQuery query);
}
