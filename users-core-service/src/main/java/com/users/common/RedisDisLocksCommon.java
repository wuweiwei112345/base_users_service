package com.users.common;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: wuwei
 * @Date: 2020/7/13 16:40
 * @Description:redis分布式锁工具类
 */
public class RedisDisLocksCommon {

    private StringRedisTemplate template;
    private String keyValue;
    private Integer retryNum = 3;//默认尝试次数3
    private Long sleepTime = 1000L;//获取锁失败睡眠时间(毫秒)
    private Long expireTime = 5000L;//锁默认过期时间(毫秒)

    private final static String KEY_TEMPLE = "redis.dis.lock:{value}";

    public String stringToNum(String value){
        if(value == null || "".equals(value)){
            return null;
        }
        //将string字符串转换为数字字符串
        StringBuffer sb = new StringBuffer();
        char[] charArr = value.toCharArray();
        int charLen = charArr.length;
        for (int i = 0 ; i < charLen ; i++) {
            char a = charArr[i];
            int a1 = a;
            sb.append(a1);
        }
        return sb.toString();
    }

    public RedisDisLocksCommon(StringRedisTemplate template,String value){
        if(template != null && value != null && !("".equals(value))){
            this.template = template;
            this.keyValue = KEY_TEMPLE.replace("{value}",stringToNum(value));
        }
    }

    public RedisDisLocksCommon(StringRedisTemplate template,String value,Integer retryNum){
        this(template,value);
        if(retryNum != null && retryNum.intValue() > 0){
            this.retryNum = retryNum;
        }
    }

    public RedisDisLocksCommon(StringRedisTemplate template,String value,Long sleepTime){
        this(template,value);
        if(sleepTime != null && sleepTime.longValue() > 0){
            this.sleepTime = sleepTime;
        }
    }

    public RedisDisLocksCommon(StringRedisTemplate template,String value,Integer retryNum,Long sleepTime){
        this(template,value);
        if(retryNum != null && retryNum.intValue() > 0){
            this.retryNum = retryNum;
        }
        if(sleepTime != null && sleepTime.longValue() > 0){
            this.sleepTime = sleepTime;
        }
    }

    public boolean getLock(){
        try {
            //循环方法获取锁
            while(true){
                //获取锁(设置setnx方式key=1)
                boolean bool = template.opsForValue().setIfAbsent(keyValue,"1");
                //尝试获取锁次数递减1
                retryNum--;
                //判断是否获取到锁
                if(!bool){
                    //尝试次数==0则直接返回失败(为0表示没有再次尝试的机会,直接返回失败即可)
                    if(retryNum == 0){
                        return false;
                    }
                    //如果没获取到锁则睡眠1秒
                    System.out.println(keyValue + "加锁失败.开始睡眠!");
                    Thread.sleep(sleepTime);//睡眠
                    continue;
                }else{
                    System.out.println(keyValue + "加锁成功!");
                    //为锁设置过期时间
                    template.expire(keyValue,expireTime,TimeUnit.MILLISECONDS);
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
