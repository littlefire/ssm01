package com.xty.ssm.service.impl;

import com.xty.ssm.dao.UserDao;
import com.xty.ssm.model.User;
import com.xty.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        System.out.println("业务层被执行了");
        List<User> users = userDao.findAll();
        return users;
    }
}
