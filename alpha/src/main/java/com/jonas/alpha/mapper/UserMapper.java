package com.jonas.alpha.mapper;


import com.jonas.alpha.model.Role;
import com.jonas.alpha.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserByname(String username);
    List<Role> getUserRoleByname(String username);
}
