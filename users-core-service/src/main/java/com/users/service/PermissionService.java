package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.AddPermissionRequestEntity;
import com.users.bean.request.QueryPermissionRequestEntity;
import com.users.dao.mapper.PermissionMapper;
import com.users.dao.po.Permission;
import com.users.dao.po.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/24 16:36
 * @Description:权限业务逻辑类
 */
@Service
public class PermissionService {

    @Autowired
    public PermissionMapper permissionMapper;

    /**
     * 添加单个权限数据
     * 功能描述: 添加单个权限数据
     * @param: entity 单个权限数据实体
     *      Integer permissionId;//表记录主键
     *      String permissionName;//权限名称
     *      String permissionDescribe;//权限描述
     *      Integer isDisable;//0启用1禁用
     *      Date create_datetime;//创建时间
     *      Date update_datetime;//最后修改时间
     * @return: 统一响应实体ResponseEntity
     * @auther: wuwei
     * @date: 2020/6/28 15:07
     */
    public ResponseEntity addPermission(AddPermissionRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getPermissionName() == null || "".equals(entity.getPermissionName())){
            return ResponseEntity.getFailEntity("permissionName不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        Permission permission = new Permission();
        permission.setPermissionName(entity.getPermissionName());//权限名称
        permission.setPermissionDescribe(entity.getPermissionDescribe());//权限描述
        permission.setCreateDatetime(currentDateTime);//创建时间
        permission.setUpdateDatetime(currentDateTime);//修改时间
        permission.setIsDisable(entity.getIsDisable());//启用禁用
        int count = permissionMapper.insert(permission);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity("添加成功!");
        }else{
            return ResponseEntity.getFailEntity("添加失败!");
        }
    }

    /**
     * 查询权限数据(全部)
     * 功能描述: 查询权限数据(全部)
     * @param:
     * @return: 权限数据集合
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity queryPermissionByCondition(QueryPermissionRequestEntity entity){
        PermissionExample example = new PermissionExample();
        //判断是否传入查询条件
        if(entity == null){
            List<Permission> list = permissionMapper.selectByExample(example);
            return ResponseEntity.getSuccessEntityByListData(null,list);
        }
        //判断传入的查询条件并拼接
        PermissionExample.Criteria criteria = example.createCriteria();
        //表记录主键
        if(entity.getPermissionId() != null && entity.getPermissionId().intValue() > 0){
            criteria.andPermissionIdEqualTo(entity.getPermissionId());
        }
        //权限名称
        if(entity.getPermissionName() != null && !("".equals(entity.getPermissionName()))){
            criteria.andPermissionNameLike("%" + entity.getPermissionName()  + "%");
        }
        //权限描述
        if(entity.getPermissionDescribe() != null && !("".equals(entity.getPermissionDescribe()))){
            criteria.andPermissionDescribeLike("%" + entity.getPermissionDescribe()  + "%");
        }
        //0启用1禁用
        if(entity.getIsDisable() != null && entity.getIsDisable() > 0){
            criteria.andIsDisableEqualTo(entity.getIsDisable());
        }
        //创建时间
        if(entity.getCreateDatetimeStart() != null && entity.getCreateDatetimeEnd() != null){
            criteria.andCreateDatetimeBetween(DateTimeUtil.getDate(entity.getCreateDatetimeStart(),DateTimeUtil.YYYYMMDD_HHMMSS),
                    DateTimeUtil.getDate(entity.getCreateDatetimeEnd(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        if(entity.getCreateDatetimeStart() != null && entity.getCreateDatetimeEnd() == null){
            criteria.andCreateDatetimeGreaterThanOrEqualTo(DateTimeUtil.getDate(entity.getCreateDatetimeStart(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        if(entity.getCreateDatetimeEnd() != null && entity.getCreateDatetimeStart() == null){
            criteria.andCreateDatetimeLessThanOrEqualTo(DateTimeUtil.getDate(entity.getCreateDatetimeEnd(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        //最后修改时间
        if(entity.getUpdateDatetimeStart() != null && entity.getUpdateDatetimeEnd() != null){
            criteria.andUpdateDatetimeBetween(DateTimeUtil.getDate(entity.getUpdateDatetimeStart(),DateTimeUtil.YYYYMMDD_HHMMSS),
                    DateTimeUtil.getDate(entity.getUpdateDatetimeEnd(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        if(entity.getUpdateDatetimeStart() != null && entity.getUpdateDatetimeEnd() == null){
            criteria.andUpdateDatetimeGreaterThanOrEqualTo(DateTimeUtil.getDate(entity.getUpdateDatetimeStart(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        if(entity.getUpdateDatetimeEnd() != null && entity.getUpdateDatetimeStart() == null){
            criteria.andUpdateDatetimeLessThanOrEqualTo(DateTimeUtil.getDate(entity.getUpdateDatetimeEnd(),DateTimeUtil.YYYYMMDD_HHMMSS));
        }
        //执行查询
        List<Permission> list = permissionMapper.selectByExample(example);
        return ResponseEntity.getSuccessEntityByListData(null,list);
    }

}
