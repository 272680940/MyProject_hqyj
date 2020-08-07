package com.hqyj.controller;

import com.hqyj.pojo.*;
import com.hqyj.service.CustomerService;
import com.hqyj.service.HouseService;
import com.hqyj.service.EnterService;
import com.hqyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    private EnterService enterService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

/*#############################      预约登记    #####################################*/
    //跳转到入住信息管理页面
    @RequestMapping("enterPage.do")
    public String enterPage(Enter1 enter, Model model, Page page,House1 house, HttpServletRequest req){
        Integer hId = house.gethId();//通过hId查询客房

        //分页查询：准备入住信息页面展示的数据
        page.setCurrentPage(page.getCurrentPage());
        Map<String, Object> map = enterService.selectEnterInfoByPage(enter,hId);


        //查询预约的客房条数
        int num = enterService.selectOrderRoomByeState();
        if(num==0){
            model.addAttribute("msg","当前没有预定的客房！");
        }

        //通过获取存储在session的操作者id查询User对象
        User1 user = userService.selectUserById((Integer)(req.getSession().getAttribute("user_id")));
        model.addAttribute("user",user);

        //把数据传到前端
        model.addAttribute("map",map);
        model.addAttribute("hId",hId);
        return "user/enterPage";
    }

    //ajax请求：查询客户入住信息
    //通过客户ID(cId)查询房间信息、楼层信息和客户信息，并携带操作员信息，展示到模态框中
    @RequestMapping("selectInfoByCustomerId.ajax")
    @ResponseBody
    public Enter1 selectInfoByCustomerId(Customer1 customer){
        return enterService.selectInfoByCustomerId(customer.getcId());
    }

    //ajax请求：编辑客户入住信息
    @RequestMapping(value = "updateInfo.ajax",method = RequestMethod.POST)
    @ResponseBody
    public int updateInfo(Enter1 enter ,House1 house){
        house.sethId(enter.getHouseId());
        house.sethState(3);
        houseService.updatehState(house);
        return enterService.updateInfo(enter);
    }

/*#############################      预约登记    #####################################*/




/*#############################      无预约登记    #####################################*/

    //跳转到状态为空闲客房的信息页面
    @RequestMapping("vacantRoomPage.do")
    public String vacantRoomPage(Model model, House1 house, Page page, HttpServletRequest req){
        page.setCurrentPage(page.getCurrentPage());
        //分页查询：查询house表，展示空闲状态的客房
        Map<String, Object> map = houseService.selectAllHouseByPage(house);
        model.addAttribute("map",map);

        //通过获取存储在session的操作者id查询User对象
        User1 user = userService.selectUserById((Integer)(req.getSession().getAttribute("user_id")));
        model.addAttribute("user",user);

        //假设没有空闲的客房，要在前端显示“当前没有空闲的客房”
        int i = houseService.selectVacantRoom();
        if (i==0){
            model.addAttribute("msg","当前没有空闲的客房");
        }

        //得到条件搜索的hAmount的状态
        Integer hAmountState = house.gethAmount();
        model.addAttribute("hAmount",house.gethAmount());
        return "user/housePage";
    }


    //ajax请求：通过hId查询客房信息
    @RequestMapping("selectHouseById.ajax")
    @ResponseBody
    public House1 selectHouseById(House1 house){
        return houseService.selectHouseById(house.gethId());
    }

    //ajax请求：无预约登记客房信息信息
    @RequestMapping("updateEnterHouse.ajax")
    @ResponseBody
    public int updateEnterHouse(Enter1 enter, Customer1 customer, User1 user,House1 house){

        //登记客人信息
        customerService.addCustomer(customer);
        Integer cId = customer.getcId();
        Integer uId = user.getuId();
        Integer hId = house.gethId();
        house.sethId(hId);
            //客房信息登记后
            //(1)将house表的状态改变;  1:空闲、2:已订、3:在住
            house.sethState(3);
            houseService.updatehState(house);
            //(2)将enter表的状态改变;  1:预定、2:正在住、3:已退
            enter.seteState(2);
        enter.setCustomerId(cId);//加入客户id
        enter.setHouseId(hId);//加入房间id
        enter.setUserId(uId);//加入操作员id
        return enterService.insertInfo(enter);

    }
/*#############################      无预约登记    #####################################*/
}
