package com.yuanziren.mapper;


import com.yuanziren.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    public User queryUserById(Integer id);
    public User queryUserByName(String userName);
    public User queryUserByUser(User user);
    public User queryUserByMap(Map map);
    public User queryUserByNameAndId(@Param("id") Integer id, @Param("userName") String userName);
}
