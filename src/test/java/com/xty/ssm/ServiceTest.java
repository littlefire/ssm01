package com.xty.ssm;

import com.xty.ssm.model.User;
import com.xty.ssm.service.UserService;
import com.xty.ssm.util.RedisCacheUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {

    private RedisCacheUtil redisCacheUtil;

    @Before
    public void setUp(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        redisCacheUtil = applicationContext.getBean("redisCache",RedisCacheUtil.class);
    }

    @Test
    public void redisTest(){
        redisCacheUtil.hset("user","username1","zhangsan1");
        String username = redisCacheUtil.hget("user","username");
        System.out.println(username);
    }


    @Test
    public void findAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        userService.findAll();
    }

    @Test
    public void mybatisT(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        List<User> users = userService.findAll();
        for (User user:users) {
            System.out.println(user.toString());
        }
    }
}
