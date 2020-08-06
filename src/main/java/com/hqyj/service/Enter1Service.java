package com.hqyj.service;

import com.hqyj.pojo.Enter1;

import java.util.List;
import java.util.Map;

public interface Enter1Service {
    //分页查询
    Map<String,Object> selectEnterInfoByPage(Enter1 enter, Integer hId);

}
