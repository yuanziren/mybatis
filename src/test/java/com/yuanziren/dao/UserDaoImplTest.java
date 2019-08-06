package com.yuanziren.dao;

import com.yuanziren.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    SqlSessionFactory sqlSessionFactory;
    UserDaoImpl userDao;
    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }


    @Test
    public void queryUserById() throws Exception {
        User user = userDao.queryUserById(6);
        System.out.println(user);
    }

    @Test
    public void queryUserByName() throws Exception {
        User user = userDao.queryUserByName("jackie02");
        System.out.println(user);
    }

    @Test
    public void queryUserByUser() throws Exception {
        User user1 = new User();
        user1.setUserName("jackie02");
        User user = userDao.queryUserByUser(user1);
        System.out.println(user);
    }

    @Test
    public void queryUserByMap() throws Exception {
        Map map = new HashMap();
        map.put("userName", "jackie02");

        User user = userDao.queryUserByMap(map);
        System.out.println(user);
    }

    @Test
    public void queryUserByNameAndId() throws Exception {
        User user = userDao.queryUserByNameAndId(6,"jackie02");
        System.out.println(user);
    }
}