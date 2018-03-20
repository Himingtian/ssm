package com.learnssm.ssm.service.impl;

import com.learnssm.ssm.mapper.UserMapper;
import com.learnssm.ssm.po.User;
import com.learnssm.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserSericerImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;
    @Override
    public List<User> getUser(User user) {

        return userMapper.getUser(user);
    }
}
