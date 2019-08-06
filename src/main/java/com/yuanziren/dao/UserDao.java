package com.yuanziren.dao;


import com.yuanziren.po.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select id,user_name as userName,user_pwd as userPwd from user where id=#{id}")
    public User queryUserById(Integer id);

}
