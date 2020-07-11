package com.users.client;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.RegisterUserInfoRequestEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 11:23
 * @Description:用户业务Feign接口类
 */
@FeignClient("${FEIGN.USERS.NAME}")
@RequestMapping("/users")
public interface UsersClient {

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
    public ResponseEntity registerUserInfo(RegisterUserInfoRequestEntity entity);

}
