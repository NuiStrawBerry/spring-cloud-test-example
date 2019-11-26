package com.jonas.alpha.service;

import com.jonas.alpha.mapper.UserMapper;
import com.jonas.alpha.model.Role;
import com.jonas.alpha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userMapper.getUserByname(username);
        if (null != users && users.size() > 0) {
            User user =  users.get(0);
            user.setRoles(getUserRoles(username));
            return user;
        }else{
            throw new UsernameNotFoundException("user not found");
        }
    }

    public List<Role> getUserRoles(String username) throws UsernameNotFoundException {
        List<Role> roles = userMapper.getUserRoleByname(username);
        return roles;
    }
}
