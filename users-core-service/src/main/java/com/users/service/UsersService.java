package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.MD5Utils;
import com.tools.mgutil.RegUtil;
import com.users.bean.request.RegisterUserInfoRequestEntity;
import com.users.dao.mapper.UsersMapper;
import com.users.dao.po.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 10:58
 * @Description:用户业务逻辑类
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

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
    public ResponseEntity registerUserInfo(RegisterUserInfoRequestEntity entity){
        //验证参数
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getUserName() == null || "".equals(entity.getUserName())){
            return ResponseEntity.getFail("userName参数为必选!");
        }
        if(entity.getUserPassword() == null || "".equals(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数为必选!");
        }
        if(RegUtil.isAdapterPassword(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数需合法!");
        }
        if(entity.getUserPhonenum() == null || "".equals(entity.getUserPhonenum())){
            return ResponseEntity.getFail("userPhonenum参数为必选!");
        }
        //将密码进行MD5加密
        String userPasswordByMD5 = MD5Utils.getMD5(entity.getUserPassword());
        //构建用户信息实体
        Users user = new Users();
        user.setUserName(entity.getUserName());
        user.setUserPassword(userPasswordByMD5);
        user.setIsDisable(0);
        user.setCreateDatetime(new Date());
        //执行用户添加
        int count = usersMapper.insert(user);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

}
