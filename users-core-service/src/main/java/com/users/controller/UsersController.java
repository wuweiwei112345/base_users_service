package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.LoginRequestEntity;
import com.users.bean.request.RegisterUserInfoRequestEntity;
import com.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 11:21
 * @Description:用户业务控制器类
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 注册用户信息
     * 功能描述:注册用户信息
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @return: 是否注册成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    @RequestMapping(value = "/registeruserinfo",method = RequestMethod.POST)
    public ResponseEntity registerUserInfo(RegisterUserInfoRequestEntity entity){
        return usersService.registerUserInfo(entity);
    }

    /**
     * 用户登录
     * 功能描述: 用户登录
     * @param: String userName;//用户名
     * @param: String userPassword;//用户密码
     * @return: 统一响应实体 用户登录token
     * @auther: wuwei
     * @date: 2020/7/11 15:26
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(LoginRequestEntity entity){
        return usersService.login(entity);
    }

}
