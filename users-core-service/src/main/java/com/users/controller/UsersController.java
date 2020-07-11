package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.LoginRequestEntity;
import com.users.bean.request.RegisterUserInfoRequestEntity;
import com.users.bean.request.SelectUsersListByConditionRequestEntity;
import com.users.bean.request.UpdateUserInfoByIdRequestEntity;
import com.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 注册用户信息
     * 功能描述:注册用户信息
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @param: Integer isAdmin;//是否是管理员 0非管理员 1管理员
     * @return: 是否注册成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    @RequestMapping(value = "/updateuserinfobyuserid",method = RequestMethod.POST)
    public ResponseEntity updateUserInfoByUserId(UpdateUserInfoByIdRequestEntity entity){
        return usersService.updateUserInfoByUserId(entity);
    }

    /**
     * 用户启用
     * 功能描述:用户启用
     * @param: Integer userId;//用户id
     * @return: 是否启用成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    @RequestMapping(value = "/activatebyuserid",method = RequestMethod.POST)
    public ResponseEntity activateByUserId(@RequestParam(value = "userId") Integer userId){
        return usersService.activateByUserId(userId);
    }

    /**
     * 用户禁用
     * 功能描述:用户禁用
     * @param: Integer userId;//用户id
     * @return: 是否禁用成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    @RequestMapping(value = "/disablebyuserid",method = RequestMethod.POST)
    public ResponseEntity disableByUserId(@RequestParam(value = "userId") Integer userId){
        return usersService.disableByUserId(userId);
    }

    /**
     * 用户信息条件查询请求参数类
     * 功能描述: 用户信息条件查询请求参数类
     * @param: Integer userId;//表记录主键id
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userEmail;//用户邮箱(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @param: Integer isDisable;//0启用1禁用
     * @param: Integer isAdmin;//0非管理员 1管理员
     * @param: String createDatetimeStart;//创建时间起始
     * @param: String createDatetimeEnd;//创建时间结束
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/7/11 21:52
     */
    @RequestMapping(value = "/selectuserslistbycondition",method = RequestMethod.POST)
    public ResponseEntity selectUsersListByCondition(SelectUsersListByConditionRequestEntity entity){
        return usersService.selectUsersListByCondition(entity);
    }

}
