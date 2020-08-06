package com.hqyj.service.impl;

import com.hqyj.dao.Customer1Mapper;
import com.hqyj.pojo.Customer1;
import com.hqyj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private Customer1Mapper customer1Mapper;

    //添加客人信息
    public int addCustomer(Customer1 customer) {
        return customer1Mapper.insertSelective(customer);
    }
}
