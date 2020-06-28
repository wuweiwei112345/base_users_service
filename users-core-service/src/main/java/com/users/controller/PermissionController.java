package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddPermissionRequestEntity;
import com.users.bean.request.QueryPermissionRequestEntity;
import com.users.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/28 15:26
 * @Description:权限请求控制器类
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

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

}
