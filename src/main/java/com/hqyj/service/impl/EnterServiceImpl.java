package com.hqyj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.Enter1Mapper;
import com.hqyj.pojo.Enter1;
import com.hqyj.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnterServiceImpl implements EnterService {
    @Autowired
    private Enter1Mapper enter1Mapper;

    //分页查询：入住信息
    public Map<String, Object> selectEnterInfoByPage(Enter1 enter, Integer hId) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(enter.getCurrentPage(),enter.getPageNumSize());
        List<Enter1> enterList = enter1Mapper.selectEnterInfo(hId);
        PageInfo<Enter1> pageInfo = new PageInfo<Enter1>(enterList);
        map.put("pageInfo",pageInfo.getList());//分页的所有数据
        map.put("total",pageInfo.getTotal());//总条数
        map.put("pages",pageInfo.getPages());//总页数
        map.put("prePage",pageInfo.getPrePage());//上一页
        map.put("nextPage",pageInfo.getNextPage());//下一页
        map.put("firstPage",pageInfo.getFirstPage());//首页
        map.put("lastPage",pageInfo.getLastPage());//尾页
        map.put("isHasNextPage",pageInfo.isHasNextPage());//是否有下一页
        map.put("isHasPreviousPage",pageInfo.isHasPreviousPage());//是否有上一页
        map.put("pageNum",pageInfo.getPageNum());//当前页码
        return map;
    }

    //通过客户ID(cId)查询房间信息、楼层信息和客户信息，并携带操作员信息，展示到模态框中
    public Enter1 selectInfoByCustomerId(Integer cId) {
        return enter1Mapper.selectInfoByCustomerId(cId);
    }

    //添加客户登记信息
    public int updateInfo(Enter1 enter) {
        return enter1Mapper.updateByPrimaryKeySelective(enter);
    }

    //查询有多少预约房间
    public int selectOrderRoomByeState() {
        return enter1Mapper.selectOrderRoomByeState();
    }

    //添加无预约的入住信息
    public int insertInfo(Enter1 enter) {
        return enter1Mapper.insertSelective(enter);
    }
}
