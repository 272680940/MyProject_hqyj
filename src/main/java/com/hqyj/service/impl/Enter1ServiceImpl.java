package com.hqyj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.Enter1Mapper;
import com.hqyj.pojo.Enter1;
import com.hqyj.service.Enter1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Enter1ServiceImpl implements Enter1Service {
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


}
