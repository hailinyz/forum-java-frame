package com.blog.service;

import com.blog.entity.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    
    void register(User user);
    void update(User user);
    void updatePassword(Long id, String oldPassword, String newPassword);
    void updateStatus(Long id, Integer status);
    void deleteById(Long id);
    
    boolean checkPassword(String rawPassword, String encodedPassword);
}
