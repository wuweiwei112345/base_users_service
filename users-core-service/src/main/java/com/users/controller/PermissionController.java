package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.*;
import com.users.client.PermissionClient;
import com.users.common.RedisDisLocksCommon;
import com.users.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: wuwei
 * @Date: 2020/6/28 15:26
 * @Description:权限请求控制器类
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/fegintest",method = RequestMethod.POST)
    public ResponseEntity feginTest(@RequestParam(value = "code") Integer code){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,String.valueOf(code));
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = permissionService.feginTest(code);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/addpermission",method = RequestMethod.POST)
    public ResponseEntity addPermission(AddPermissionRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getPermissionKey());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = permissionService.addPermission(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/querypermissionbycondition",method = RequestMethod.POST)
    public ResponseEntity queryPermissionByCondition(QueryPermissionRequestEntity entity){
        return permissionService.queryPermissionByCondition(entity);
    }

    @RequestMapping(value = "/deletepermissionbyid",method = RequestMethod.POST)
    public ResponseEntity deletePermissionById(@RequestParam(value = "id") Integer id){
        return permissionService.deletePermissionById(id);
    }

    @RequestMapping(value = "/updatepermissionbyid",method = RequestMethod.POST)
    public ResponseEntity updatePermissionById(UpdatePermissionRequestEntity entity){
        return permissionService.updatePermissionById(entity);
    }

    @RequestMapping(value = "/addpermissionelement",method = RequestMethod.POST)
    public ResponseEntity addPermissionElement(AddPermissionElementEntity entity){
        return permissionService.addPermissionElement(entity);
    }

    @RequestMapping(value = "/deletepermissionbyids",method = RequestMethod.POST)
    public ResponseEntity deletePermissionByIds(DeletePermissionElementEntity entity){
        return permissionService.deletePermissionByIds(entity);
    }

}
