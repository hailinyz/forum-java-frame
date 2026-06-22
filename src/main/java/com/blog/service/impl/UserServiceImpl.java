package com.blog.service.impl;

import com.blog.entity.User;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
    
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    
    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
    
    @Override
    public void register(User user) {
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        
        User existingEmail = userMapper.findByEmail(user.getEmail());
        if (existingEmail != null) {
            throw new RuntimeException("邮箱已被注册");
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        userMapper.insert(user);
    }
    
    @Override
    public void update(User user) {
        userMapper.update(user);
    }
    
    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User user = userMapper.findById(id);
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("原密码错误");
        }
        
        String encodedPassword = passwordEncoder.encode(newPassword);
        userMapper.updatePassword(id, encodedPassword);
    }
    
    @Override
    public void updateStatus(Long id, Integer status) {
        userMapper.updateStatus(id, status);
    }
    
    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }
    
    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
