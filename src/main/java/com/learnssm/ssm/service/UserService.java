package com.learnssm.ssm.service;

import com.learnssm.ssm.po.User;

import java.util.List;

public interface UserService {
    List<User> getUser(User user);
}
