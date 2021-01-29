package com.eg.fcloud.webapp.service;

import com.eg.fcloud.webapp.entity.User;
import com.eg.fcloud.webapp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Random;

/**
 * @Author: CAOPING
 * @Date: 2021/1/28 21:24
 * @Description:
 */
@SpringBootTest
@ComponentScan(basePackages = "com.eg.fcloud")
@EnableTransactionManagement
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.eg.fcloud.*.mapper")
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void testAdd(){
        User user = new User();
        user.setAge(new Random(50).nextInt(30));
        user.setUserName("zhaosi");
        user.setUserCode("zhs");
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserName("wangw");
        user.setId(1354976128566054914L);
        userMapper.updateById(user);
    }

    @Test
    public void testDeleta(){
        int row = userMapper.deleteById(1354971262150098946L);
        System.out.println(row);
    }

    @Test
    public void testFind(){
        User users = userMapper.selectById(1);
        System.out.println(users);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme