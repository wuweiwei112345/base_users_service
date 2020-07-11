package com.users.client;

import com.tools.entity.ResponseEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wuwei
 * @Date: 2020/7/3 17:44
 * @Description: 权限请求Feign接口类
 */
@FeignClient("${FEIGN.USERS.NAME}")
@RequestMapping("/permission")
public interface PermissionClient {

    @RequestMapping(value = "/fegintest",method = RequestMethod.POST)
    public ResponseEntity feginTest(@RequestParam(value = "code") Integer code);

}
