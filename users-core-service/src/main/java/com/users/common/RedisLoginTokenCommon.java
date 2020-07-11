package com.users.common;

import com.tools.mgutil.DateTimeUtil;
import com.tools.mgutil.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 15:48
 * @Description:登录token工具类
 */
@Service
public class RedisLoginTokenCommon {

    @Autowired
    private StringRedisTemplate template;

    private static final String LOGIN_TOKEN_KEY = "user_login_token:{userId}";

    /**
     * 生成指定用户登录token
     * 功能描述: 生成指定用户登录token
     * @param: String userId;//用户登录id 必选
     * @return: 返回用户登录token值
     * @auther: wuwei
     * @date: 2020/7/11 16:08
     */
    public static String createLoginUser(String userId){
        String value = userId.concat(String.valueOf(System.currentTimeMillis()));
        return MD5Utils.getMD5(value);
    }

    /**
     * 设置用户登录token
     * 功能描述: 设置用户登录token
     * @param: String userId;//用户登录id 必选
     * @param: String token;//用户登录token 必选
     * @return: true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 15:58
     */
    public boolean setLoginToken(String userId,String token){
        String key = LOGIN_TOKEN_KEY.replace("{userId}",userId);
        template.opsForValue().set(key,token,7, TimeUnit.DAYS);
        return true;
    }

    /**
     * 获取用户登录token
     * 功能描述: 获取用户登录token
     * @param: String userId;//用户登录id 必选
     * @return: 用户登录token值
     * @auther: wuwei
     * @date: 2020/7/11 15:58
     */
    public String getLoginToken(String userId){
        String key = LOGIN_TOKEN_KEY.replace("{userId}",userId);
        String token = template.opsForValue().get(key);
        return token;
    }

}
