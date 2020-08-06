package com.hqyj.controller;

import com.hqyj.pojo.Enter1;
import com.hqyj.pojo.House1;
import com.hqyj.pojo.Page;
import com.hqyj.service.HouseService;
import com.hqyj.service.Enter1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;
import java.util.Map;

/**
 * author  Jayoung
 * createDate  2020/8/3 0003 15:05
 * version 1.0
 */
@Controller
@RequestMapping("uc")
public class UserController {
    @Autowired
    private Enter1Service enter1Service;

    @Autowired
    private HouseService houseService;

    //跳转到入住信息管理页面
    @RequestMapping("enterPage.do")
    public String enterPage(Enter1 enter, Model model, Page page,House1 house){
        Integer hId = house.gethId();
        System.out.println("------------------------------"+hId);
        page.setCurrentPage(page.getCurrentPage());
        //准备入住信息页面展示的数据
        Map<String, Object> map = enter1Service.selectEnterInfoByPage(enter,hId);
        model.addAttribute("map",map);
        return "user/enterPage";
    }

    /*//分页信息
    @RequestMapping(value = "selectInfoByPage.do",method = RequestMethod.POST)
    @ResponseBody
    public List<Enter1> selectInfoByPage(){
        List<Enter1> enter1s = userService.selectInfoByPage();
        return enter1s;

    }*/

    //跳转到空房信息页面
    @RequestMapping("vacantRoomPage.do")
    public String vacantRoomPage(Model model){
        //查询house表，展示空闲状态的客房
        List<House1> houseList = houseService.selectAllHouse();
        model.addAttribute("houseList",houseList);
        return "user/housePage";
    }

    //ajax请求：通过hId查询房间信息，展示到模态框中
    @RequestMapping("selectHouseById.ajax")
    @ResponseBody
    public House1 selectHouseById(String hId){
        return houseService.selectHouseById(new Integer(hId));
    }


}
