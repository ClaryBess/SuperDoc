package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 设置访问路由值为路径
//    @RequestMapping("/")
//    public ModelAndView index(){
//        // 顾名思义 实体和数据 同时返回页面模板和数据
//        ModelAndView mav = new ModelAndView("index");
//        List<User> list = userService.getAll();
//        mav.addObject("list",list);
//        return mav;
//    }
}
