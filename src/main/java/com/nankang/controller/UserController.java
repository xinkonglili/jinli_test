package com.nankang.controller;

import com.alibaba.fastjson.JSONObject;
import com.nankang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping( value = "/updateUser",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        user.setAge(user.getAge()+1);
        String result = JSONObject.toJSONString(user); //将一个实体对象转换成Json字符串
        return result;
    }

}
