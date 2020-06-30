package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.*;
import com.users.dao.mapper.PermissionElementMapper;
import com.users.dao.mapper.PermissionMapper;
import com.users.dao.po.Permission;
import com.users.dao.po.PermissionElement;
import com.users.dao.po.PermissionElementExample;
import com.users.dao.po.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    private PermissionMapper permissionMapper;
    @Autowired
    private PermissionElementMapper permissionElementMapper;

    /**
     * 添加单个权限数据
     * 功能描述: 添加单个权限数据
     * @param: entity 单个权限数据实体
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
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
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

    /**
     * 删除权限数据根据id
     * 功能描述: 删除权限数据根据id
     * @param: Integer id 主键id
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity deletePermissionById(Integer id){
        //参数
        if(id == null || id.intValue() <= 0){
            return ResponseEntity.getFailEntity("删除失败!");
        }
        //执行删除
        int count = permissionMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);//返回成功
        }else{
            return ResponseEntity.getFailEntity(null);//返回失败
        }
    }

    /**
     * 修改单个权限数据
     * 功能描述: 修改单个权限数据
     * @param: entity 单个权限数据实体
     *      Integer permissionId;//表记录主键
     *      String permissionName;//权限名称
     *      String permissionDescribe;//权限描述
     *      Integer isDisable;//0启用1禁用
     * @return: 统一响应实体ResponseEntity
     * @auther: wuwei
     * @date: 2020/6/28 15:07
     */
    public ResponseEntity updatePermissionById(UpdatePermissionRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getPermissionId() == null || entity.getPermissionId().intValue() <= 0){
            return ResponseEntity.getFailEntity("permissionId不能为空!");
        }
        if(entity.getPermissionName() == null || "".equals(entity.getPermissionName())){
            return ResponseEntity.getFailEntity("permissionName不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建修改数据实体
        Permission permission = new Permission();
        permission.setPermissionId(entity.getPermissionId());//权限id
        permission.setPermissionName(entity.getPermissionName());//权限名称
        permission.setPermissionDescribe(entity.getPermissionDescribe());//权限描述
        permission.setIsDisable(entity.getIsDisable());//启用禁用
        permission.setUpdateDatetime(currentDateTime);//修改时间
        int count = permissionMapper.updateByPrimaryKeySelective(permission);//执行修改
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

    /**
     * 关联权限与权限元素之间的关系
     * 功能描述: 关联权限与权限元素之间的关系
     * @param: entity 添加参数实体
     *      Integer permissionId;//权限id
     *      Integer elementId;//权限关联元素id
     *      Integer elementType;//权限关联子元素类型
     * @return:
     * @auther: wuwei
     * @date: 2020/6/30 15:17
     */
    public ResponseEntity addPermissionElement(AddPermissionElementEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("请传入参数!");
        }
        if(entity.getPermissionId() == null || entity.getElementId().intValue() <= 0){
            return ResponseEntity.getFailEntity("permissionId参数为必选!");
        }
        if(entity.getElementId() == null || entity.getElementId().intValue() <= 0){
            return ResponseEntity.getFailEntity("elementId参数为必选!");
        }
        if(entity.getElementType() == null ||
                !(entity.getElementType().intValue() == 1 ||
                        entity.getElementType().intValue() == 2 ||
                        entity.getElementType().intValue() == 3 ||
                        entity.getElementType().intValue() == 4)){
            return ResponseEntity.getFailEntity("elementType参数为必选或需合法!");
        }
        //执行添加
        Date currentDateTime = new Date();//当前时间
        PermissionElement permissionElement = new PermissionElement();
        permissionElement.setPermissionId(entity.getPermissionId());//权限id
        permissionElement.setElementId(entity.getElementId());//权限关联元素id
        permissionElement.setElementType(entity.getElementType());//权限关联子元素类型(菜单1、页面元素2、文件3、功能4)					0	0	0	0	0	0	0
        permissionElement.setCreateDatetime(currentDateTime);//创建时间
        int count = permissionElementMapper.insert(permissionElement);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

    /**
     * 删除权限与权限元素之间的关系根据主键id集合
     * 功能描述: 删除权限与权限元素之间的关系根据主键id集合
     * @param: entity 添加参数实体
     *      Integer ids;//主键id集合
     * @return:
     * @auther: wuwei
     * @date: 2020/6/30 15:17
     */
    public ResponseEntity deletePermissionByIds(DeletePermissionElementEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("请传入参数!");
        }
        if(CollectionUtils.isEmpty(entity.getIds())){
            return ResponseEntity.getFailEntity("ids参数为必选!");
        }
        //执行删除
        PermissionElementExample example = new PermissionElementExample();
        PermissionElementExample.Criteria criteria = example.createCriteria();
        criteria.andElementIdIn(entity.getIds());//拼接in语句
        int count = permissionElementMapper.deleteByExample(example);//执行批量删除
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

}
