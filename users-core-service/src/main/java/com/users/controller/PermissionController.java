package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.RedisLock;
import com.users.bean.request.*;
import com.users.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisTemplate redisTemplate;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/addpermission",method = RequestMethod.POST)
    public ResponseEntity addPermission(AddPermissionRequestEntity entity){
        return permissionService.addPermission(entity);
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
