package com.users.service;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddRoleInfoRequestEntity;
import com.users.dao.mapper.RoleMapper;
import com.users.dao.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/7/12 11:03
 * @Description:角色业务逻辑实现类
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 添加角色信息
     * 功能描述: 添加角色信息
     * @param: String roleName;//角色名称
     * @param: String roleDescribe;//角色描述
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    public ResponseEntity addRoleInfo(AddRoleInfoRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getRoleName() == null || "".equals(entity.getRoleName())){
            return ResponseEntity.getFail("roleName参数为必选!");
        }
        if(entity.getRoleDescribe() == null || "".equals(entity.getRoleDescribe())){
            return ResponseEntity.getFail("roleDescribe参数为必选!");
        }
        //获取当前时间
        Date currentDateTime = new Date();
        //组装角色实例
        Role role = new Role();
        role.setRoleName(entity.getRoleName());
        role.setRoleDescribe(entity.getRoleDescribe());
        role.setIsDisable(0);//0未禁用
        role.setCreateDatetime(currentDateTime);
        role.setUpdateDatetime(currentDateTime);
        //执行添加
        int count = roleMapper.insert(role);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

}
