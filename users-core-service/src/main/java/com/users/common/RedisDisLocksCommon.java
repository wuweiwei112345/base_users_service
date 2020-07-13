package com.users.common;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: wuwei
 * @Date: 2020/7/13 16:40
 * @Description:redis分布式锁工具类
 */
public class RedisDisLocksCommon {

    private final StringRedisTemplate template;
    private final String keyValue;

    private final static String KEY_TEMPLE = "redis.dis.lock:{value}";

    public RedisDisLocksCommon(StringRedisTemplate template,String value)throws IllegalArgumentException{
        if(template == null || value == null || "".equals(value)){
            throw new IllegalArgumentException("参数不能为空!");
        }
        this.template = template;
        this.keyValue = KEY_TEMPLE.replace("{value}",value);
    }

    public boolean getLock(){
        try {
            //循环方法获取锁
            while(true){
                //获取锁(设置setnx方式key=1)
                boolean bool = template.opsForValue().setIfAbsent(keyValue,"1");
                if(!bool){
                    //如果没获取到锁则睡眠1秒
                    System.out.println(keyValue + "加锁失败.开始睡眠!");
                    Thread.sleep(1000L);
                    continue;
                }else{
                    System.out.println(keyValue + "加锁成功!");
                    return true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(keyValue + "加锁失败!");
        return false;
    }

    public void cancelLock(){
        template.delete(keyValue);
    }

}
