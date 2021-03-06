package com.hqyj.dao;

import com.hqyj.pojo.Enter1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Enter1Mapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Enter1 record);

    int insertSelective(Enter1 record);

    Enter1 selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Enter1 record);

    int updateByPrimaryKey(Enter1 record);

    List<Enter1> selectEnterInfo(@Param("hId") Integer hId);

    Enter1 selectInfoByCustomerId(@Param("cId") Integer cId);

    int selectOrderRoomByeState();
}