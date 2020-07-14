package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.*;
import com.users.common.RedisDisLocksCommon;
import com.users.dao.po.Role;
import com.users.dao.po.RoleExample;
import com.users.dao.po.RolePermission;
import com.users.dao.po.RolePermissionExample;
import com.users.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 15:00
 * @Description:角色控制器类
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private StringRedisTemplate template;

    /**
     * 添加角色信息
     * 功能描述: 添加角色信息
     * @param: String roleName;//角色名称
     * @param: String roleDescribe;//角色描述
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    @RequestMapping(value = "/addroleinfo",method = RequestMethod.POST)
    public ResponseEntity addRoleInfo(AddRoleInfoRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getRoleName());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = roleService.addRoleInfo(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    /**
     * 添加角色信息
     * 功能描述: 添加角色信息
     * @param: Integer roleId;//表记录主键
     * @param: String roleName;//角色名称
     * @param: String roleDescribe;//角色描述
     * @param: Integer isDisable;//0启用1禁用
     * @param: String createDatetimeStart;//创建时间起始
     * @param: String createDatetimeEnd;//创建时间结束
     * @param: String updateDatetimeStart;//最后修改时间起始
     * @param: String updateDatetimeEnd;//最后修改时间起始
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    @RequestMapping(value = "/selectroleinfobycondition",method = RequestMethod.POST)
    public ResponseEntity selectRoleInfoByCondition(SelectRoleInfoByConditionRequestEntity entity){
        return roleService.selectRoleInfoByCondition(entity);
    }

    /**
     * 修改角色信息根据角色id
     * 功能描述: 修改角色信息根据角色id
     * @param: Integer roleId;//表记录主键
     * @param: String roleName;//角色名称
     * @param: String roleDescribe;//角色描述
     * @param: Integer isDisable;//0启用1禁用
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    @RequestMapping(value = "/updateroleinfobyid",method = RequestMethod.POST)
    public ResponseEntity updateRoleInfoById(UpdateRoleInfoByIdRequestEntity entity){
        return roleService.updateRoleInfoById(entity);
    }

    /**
     * 删除角色信息根据角色id
     * 功能描述: 删除角色信息根据角色id
     * @param: Integer roleId;//表记录主键
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    @RequestMapping(value = "/deleteroleinfobyid",method = RequestMethod.POST)
    public ResponseEntity deleteRoleInfoById(@RequestParam(value = "roleId") Integer roleId){
        return roleService.deleteRoleInfoById(roleId);
    }

    /**
     * 设置角色权限之间的关系
     * 功能描述: 设置角色权限之间的关系
     * @param: Integer roleId;//角色id
     * @param: Integer permissionId;//权限id
     * @return: 返回统一响应实体
     * @auther: wuwei
     * @date: 2020/7/14 16:03
     */
    @RequestMapping(value = "/setrolepermission",method = RequestMethod.POST)
    public ResponseEntity setRolePermission(SetRolePermissionRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,String.valueOf(entity.getRoleId() + entity.getPermissionId()));
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = roleService.setRolePermission(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    /**
     * 解除角色权限之间的关系
     * 功能描述: 解除角色权限之间的关系
     * @param: Integer roleId;//角色id
     * @param: Integer permissionId;//权限id
     * @return: 返回统一响应实体
     * @auther: wuwei
     * @date: 2020/7/14 16:03
     */
    @RequestMapping(value = "/deleterolepermission",method = RequestMethod.POST)
    public ResponseEntity deleteRolePermission(DeleteRolePermissionRequestEntity entity){
        return roleService.deleteRolePermission(entity);
    }

    /**
     * 查询角色关联权限根据roleId
     * 功能描述: 查询角色关联权限根据roleId
     * @param: Integer roleId;//角色id
     * @return: 返回统一响应实体
     * @auther: wuwei
     * @date: 2020/7/14 16:03
     */
    @RequestMapping(value = "/querypermissionbyuserid",method = RequestMethod.POST)
    public ResponseEntity queryPermissionByUserId(@RequestParam(value = "roleId") Integer roleId){
        return roleService.queryPermissionByUserId(roleId);
    }

}
