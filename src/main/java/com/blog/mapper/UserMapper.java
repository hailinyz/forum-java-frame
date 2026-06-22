package com.blog.mapper;

import com.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
    int insert(User user);
    int update(User user);
    int updatePassword(@Param("id") Long id, @Param("password") String password);
    int deleteById(Long id);
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);
}
