package com.yuanziren;

import com.yuanziren.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void test01() throws IOException {
        /**
         a)、读取mybatis的配置文件
         b)、加载配置文件创建SqlSessionFactory
         c)、根据SqlSessionFactory创建SqlSession
         d)、通过sqlSession操作数据库
         e)、处理结果
         f)、关闭session
         */

        InputStream in = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = sqlSessionFactory.openSession();

        User user = session.selectOne("com.yuanziren.mapper.UserMapper.queryUserById", 6);
        System.out.println(user);

        session.close();
    }
}
