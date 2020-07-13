package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.AddRoleInfoRequestEntity;
import com.users.bean.request.QueryPermissionRequestEntity;
import com.users.bean.request.SelectRoleInfoByConditionRequestEntity;
import com.users.bean.request.UpdateRoleInfoByIdRequestEntity;
import com.users.dao.mapper.RoleMapper;
import com.users.dao.po.Role;
import com.users.dao.po.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

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
        //检查排重
        SelectRoleInfoByConditionRequestEntity queryEntity = new SelectRoleInfoByConditionRequestEntity();
        queryEntity.setRoleName(entity.getRoleName());//角色名称
        ResponseEntity responseEntity = this.selectRoleInfoByCondition(queryEntity);
        if(!(CollectionUtils.isEmpty(responseEntity.getDataList()))){
            return ResponseEntity.getFailAndCode("重复添加!",100002);
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
    public ResponseEntity selectRoleInfoByCondition(SelectRoleInfoByConditionRequestEntity entity){
        //实例化条件
        RoleExample example = new RoleExample();
        //判断是否查询全部
        if(entity == null){
            //执行查询
            List<Role> roleList = roleMapper.selectByExample(example);
            //返回数据
            return ResponseEntity.getSuccessByEntity(null,roleList);
        }
        //拼接查询条件
        RoleExample.Criteria criteria = example.createCriteria();
        if(entity.getRoleId() == null && entity.getRoleId().intValue() > 0){
            criteria.andRoleIdEqualTo(entity.getRoleId());
        }
        if(entity.getRoleName() != null && !("".equals(entity.getRoleName()))){
            criteria.andRoleNameLike("%" + entity.getRoleName() + "%");
        }
        if(entity.getRoleDescribe() != null && !("".equals(entity.getRoleDescribe()))){
            criteria.andRoleDescribeLike("%" + entity.getRoleDescribe() + "%");
        }
        if(entity.getIsDisable() != null && (entity.getIsDisable().intValue() == 0 || entity.getIsDisable().intValue() == 1)){
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
        List<Role> roleList = roleMapper.selectByExample(example);
        //返回数据
        return ResponseEntity.getSuccessByEntity(null,roleList);
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
    public ResponseEntity updateRoleInfoById(UpdateRoleInfoByIdRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getRoleId() == null || entity.getRoleId().intValue() <= 0){
            return ResponseEntity.getFail("roleId参数为必选!");
        }
        //获取当前时间
        Date currentDateTime = new Date();
        //组装角色实例
        Role role = new Role();
        role.setRoleId(entity.getRoleId());
        role.setRoleName(entity.getRoleName());
        role.setRoleDescribe(entity.getRoleDescribe());
        role.setIsDisable(0);//0未禁用
        role.setUpdateDatetime(currentDateTime);
        //执行修改
        int count = roleMapper.updateByPrimaryKeySelective(role);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

    /**
     * 删除角色信息根据角色id
     * 功能描述: 删除角色信息根据角色id
     * @param: Integer roleId;//表记录主键
     * @return: 返回统一实体
     * @auther: wuwei
     * @date: 2020/7/12 11:20
     */
    public ResponseEntity deleteRoleInfoById(Integer roleId){
        //参数检查
        if(roleId == null || roleId.intValue() <= 0){
            return ResponseEntity.getFail("roleId参数为必选!");
        }
        //执行修改
        int count = roleMapper.deleteByPrimaryKey(roleId);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

}
