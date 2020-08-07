package com.hqyj.service;

import com.hqyj.pojo.House1;

import java.util.List;
import java.util.Map;

public interface HouseService {
    //分页查询空闲的房间
    Map<String,Object> selectAllHouseByPage(House1 house);

    //查询所有空闲客房
    List<House1> selectAllHouse();

    //ajax请求：通过hId查询房间信息，展示到模态框中
    House1 selectHouseById(Integer hId);


    int updatehState(House1 house);

    //假设没有空闲的客房，要在前端显示“当前没有空闲的客房”
    int selectVacantRoom();
}
