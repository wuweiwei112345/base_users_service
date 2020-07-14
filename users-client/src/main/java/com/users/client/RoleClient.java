package com.users.client;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 15:04
 * @Description:角色Feign Client接口类
 */
@FeignClient("${FEIGN.USERS.NAME}")
@RequestMapping("/role")
public interface RoleClient {

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
    public ResponseEntity addRoleInfo(AddRoleInfoRequestEntity entity);

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
    public ResponseEntity selectRoleInfoByCondition(SelectRoleInfoByConditionRequestEntity entity);

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
    public ResponseEntity updateRoleInfoById(UpdateRoleInfoByIdRequestEntity entity);

    /**
     * 删除角色信息根据角色id
     * 功能描述: 删除角色信息根据角色id
     * @param: Integer roleId;//表记录主键
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    @RequestMapping(value = "/deleteroleinfobyid",method = RequestMethod.POST)
    public ResponseEntity deleteRoleInfoById(@RequestParam(value = "roleId") Integer roleId);

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
    public ResponseEntity setRolePermission(SetRolePermissionRequestEntity entity);

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
    public ResponseEntity deleteRolePermission(DeleteRolePermissionRequestEntity entity);

    /**
     * 查询角色关联权限根据roleId
     * 功能描述: 查询角色关联权限根据roleId
     * @param: Integer roleId;//角色id
     * @return: 返回统一响应实体
     * @auther: wuwei
     * @date: 2020/7/14 16:03
     */
    @RequestMapping(value = "/querypermissionbyuserid",method = RequestMethod.POST)
    public ResponseEntity queryPermissionByUserId(@RequestParam(value = "roleId") Integer roleId);

}
