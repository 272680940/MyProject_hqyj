package com.hqyj.service.impl;

import com.hqyj.dao.User1Mapper;
import com.hqyj.pojo.User1;
import com.hqyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User1Mapper user1Mapper;

    public User1 selectUserById(Integer user_id) {
        return user1Mapper.selectByPrimaryKey(user_id);
    }
}
