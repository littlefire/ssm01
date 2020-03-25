package com.xty.ssm.dao;

import com.xty.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
     List<User> findAll();
}
