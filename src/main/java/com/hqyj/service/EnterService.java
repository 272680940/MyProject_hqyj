package com.hqyj.service;

import com.hqyj.pojo.Enter1;

import java.util.List;
import java.util.Map;

public interface EnterService {
    //分页查询
    Map<String,Object> selectEnterInfoByPage(Enter1 enter, Integer hId);

    //通过客户ID(cId)查询房间信息、楼层信息和客户信息，并携带操作员信息，展示到模态框中
    Enter1 selectInfoByCustomerId(Integer cId);

    //添加客户登记信息
    int updateInfo(Enter1 enter);

    //查询有多少预约房间
    int selectOrderRoomByeState();

    int insertInfo(Enter1 enter);
}
