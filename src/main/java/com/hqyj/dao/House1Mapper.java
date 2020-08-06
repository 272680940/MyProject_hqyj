package com.hqyj.dao;

import com.hqyj.pojo.House1;

import java.util.List;

public interface House1Mapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(House1 record);

    int insertSelective(House1 record);

    House1 selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(House1 record);

    int updateByPrimaryKey(House1 record);

    List<House1> selectAllHouse();

    House1 selectHouseById(Integer hId);

    //分页查询所有客房数据
    List<House1> selectAllHouseByPage(House1 house);
}