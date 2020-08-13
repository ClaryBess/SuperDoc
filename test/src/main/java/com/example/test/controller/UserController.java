package com.example.test.controller;

import com.example.test.bean.CommonResult;
import com.example.test.bean.User;
import com.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{UserID}")
    public User getUserById(@PathVariable("UserID") Integer UserID){
        return userMapper.getUserById(UserID);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }

    @PostMapping("/user/regisiter")
    public CommonResult register(@RequestBody User user){
        User user1=userMapper.getUserByEmail(user.getEmail());
        if(user1!=null){
            return new CommonResult(500,"email already exists!",null);
        }
        User user2=userMapper.getUserByName(user.getUserName());
        if(user2!=null){
            return new CommonResult(400,"username already exists!",null);
        }
        User result =insertUser(user);
        return new CommonResult(200,null,result);
    }

    @RequestMapping(value="/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password ,
                        Map<String,Object> map, HttpSession session){
        User user=userMapper.getUserByName(username);
        if(user.getPassword().equals(password)){
            session.setAttribute("loginUser",user);
//            session.setAttribute("message",a);
//            return "textajax";
            return "index";
        }
        else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

}
