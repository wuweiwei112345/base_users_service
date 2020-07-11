package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.MD5Utils;
import com.tools.mgutil.RegUtil;
import com.users.bean.request.LoginRequestEntity;
import com.users.bean.request.RegisterUserInfoRequestEntity;
import com.users.common.RedisLoginTokenCommon;
import com.users.dao.mapper.UsersMapper;
import com.users.dao.po.Users;
import com.users.dao.po.UsersExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 10:58
 * @Description:用户业务逻辑类
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisLoginTokenCommon redisLoginTokenCommon;

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

    /**
     * 用户登录
     * 功能描述: 用户登录
     * @param: String userName;//用户名
     * @param: String userPassword;//用户密码
     * @return: 统一响应实体 用户登录token
     * @auther: wuwei
     * @date: 2020/7/11 15:26
     */
    public ResponseEntity login(LoginRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(StringUtils.isBlank(entity.getUserName())){
            return ResponseEntity.getFail("userName参数为必选!");
        }
        if(StringUtils.isBlank(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数为必选!");
        }
        if(RegUtil.isAdapterPassword(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数需合法!");
        }
        //查询用户
        UsersExample example = new UsersExample();
        example.or().andUserNameEqualTo(entity.getUserName());
        example.or().andUserEmailEqualTo(entity.getUserName());
        example.or().andUserPhonenumEqualTo(entity.getUserName());
        List<Users> list = usersMapper.selectByExample(example);
        //解析集合
        if(!CollectionUtils.isEmpty(list)){
            Users users = list.get(0);
            //判断密码是否一致
            if(MD5Utils.getMD5(entity.getUserPassword()).equals(users.getUserPassword())){
                String userId = users.getUserId().toString();
                //生成用户登录token
                String token = redisLoginTokenCommon.createLoginUser(userId);
                //设置token到redis数据库
                boolean bool = redisLoginTokenCommon.setLoginToken(userId,token);
                //组装返回数据
                Map<String,String> resultMap = new HashMap<String,String>();
                resultMap.put("userId",userId);
                resultMap.put("token",token);
                return ResponseEntity.getSuccessByEntity("登录成功!",resultMap);
            }else{
                return ResponseEntity.getFail("用户密码错误!");
            }
        }else{
            return ResponseEntity.getFail("没有此用户!");
        }
    }

}
