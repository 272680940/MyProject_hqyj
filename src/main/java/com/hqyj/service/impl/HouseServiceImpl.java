package com.hqyj.service.impl;

import com.hqyj.dao.House1Mapper;
import com.hqyj.pojo.House1;
import com.hqyj.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private House1Mapper houseMapper;

    //分页查询：空闲客房
    public Map<String, Object> selecHouseByBage() {


        return null;
    }

    //查询所有空闲的客房
    public List<House1> selectAllHouse() {
        return houseMapper.selectAllHouse();
    }

    //ajax请求：通过hId查询房间信息，展示到模态框中
    public House1 selectHouseById(Integer hId) {
        return houseMapper.selectHouseById(hId);
    }




}
