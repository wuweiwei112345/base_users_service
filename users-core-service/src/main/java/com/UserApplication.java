package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: wuwei
 * @Date: 2020/6/23 18:16
 * @Description:程序入口
 */
@Configuration
@SpringBootApplication(scanBasePackages = {"com.users.*"})
@MapperScan({"com.users.dao.mapper"})
@EnableDiscoveryClient
public class UserApplication {

    private static final Logger log = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.error("====启动成功====");
    }

}
