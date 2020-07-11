package com.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

/**
 * @Auther: wuwei
 * @Date: 2019/4/16 14:11
 * @Description:加载模块
 */
@Component
@EnableFeignClients(basePackages = "com.users")
public class ModuleUsersApi {

    private static final Logger log = LoggerFactory.getLogger(ModuleUsersApi.class);

    public ModuleUsersApi(){
        log.error("载入用户微服务模块feign client : com.users.feign");
    }

}
