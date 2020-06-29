package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.*;
import com.users.dao.mapper.MenuMapper;
import com.users.dao.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 17:33
 * @Description:菜单业务逻辑类
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 添加单个菜单数据
     * 功能描述: 添加单个菜单数据
     * @param: entity 单个权限数据实体
     *          String menuName;//菜单名称
     *          String menuDescribe;//菜单描述
     *          Integer isDisable;//启用1禁用
     *          Date createDatetime;//创建时间
     *          Date updateDatetime;//最后修改时间
     * @return: 统一响应实体ResponseEntity
     * @auther: wuwei
     * @date: 2020/6/28 15:07
     */
    public ResponseEntity addMenu(AddMenuRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getMenuName() == null || "".equals(entity.getMenuName())){
            return ResponseEntity.getFailEntity("menuName不能为空!");
        }
        if(entity.getMenuDescribe() == null || "".equals(entity.getMenuDescribe())){
            return ResponseEntity.getFailEntity("menuDescribe不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        Menu menu = new Menu();
        menu.setMenuName(entity.getMenuName());//菜单名称
        menu.setMenuDescribe(entity.getMenuDescribe());//菜单描述
        menu.setIsDisable(entity.getIsDisable());//启用禁用
        menu.setCreateDatetime(currentDateTime);//创建时间
        menu.setUpdateDatetime(currentDateTime);//修改时间
        int count = menuMapper.insert(menu);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

    /**
     * 条件查询菜单数据
     * 功能描述: 条件查询菜单数据
     * @param: entity 条件查询参数实体
     *      Integer menuId;//表记录主键id
     *      String menuName;//菜单名称
     *      String menuDescribe;//菜单描述
     *      Integer isDisable;//启用1禁用
     *      Date createDatetimeStart;//创建时间
     *      Date updateDatetimeEnd;//最后修改时间
     * @return: 权限数据集合
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity queryMenuByCondition(QueryMenuRequestEntity entity){
        MenuExample example = new MenuExample();
        //判断是否传入查询条件
        if(entity == null){
            List<Menu> list = menuMapper.selectByExample(example);
            return ResponseEntity.getSuccessEntityByListData(null,list);
        }
        //判断传入的查询条件并拼接
        MenuExample.Criteria criteria = example.createCriteria();
        //表记录主键
        if(entity.getMenuId() != null && entity.getMenuId().intValue() > 0){
            criteria.andMenuIdEqualTo(entity.getMenuId());
        }
        //权限名称
        if(entity.getMenuName() != null && !("".equals(entity.getMenuName()))){
            criteria.andMenuNameLike("%" + entity.getMenuName()  + "%");
        }
        //权限描述
        if(entity.getMenuDescribe() != null && !("".equals(entity.getMenuDescribe()))){
            criteria.andMenuDescribeLike("%" + entity.getMenuDescribe()  + "%");
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
        List<Menu> list = menuMapper.selectByExample(example);
        return ResponseEntity.getSuccessEntityByListData(null,list);
    }

    /**
     * 删除菜单数据根据id
     * 功能描述: 删除菜单数据根据id
     * @param: Integer id 主键id
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity deleteMenuById(Integer id){
        //参数
        if(id == null || id.intValue() <= 0){
            return ResponseEntity.getFailEntity("删除失败!");
        }
        //执行删除
        int count = menuMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);//返回成功
        }else{
            return ResponseEntity.getFailEntity(null);//返回失败
        }
    }

    /**
     * 修改单个菜单数据
     * 功能描述: 修改单个菜单数据
     * @param: entity 单个权限数据实体
     *          Integer menuId;//表记录主键id
     *          String menuName;//菜单名称
     *          String menuDescribe;//菜单描述
     *          Integer isDisable;//启用1禁用
     * @return: 统一响应实体ResponseEntity
     * @auther: wuwei
     * @date: 2020/6/28 15:07
     */
    public ResponseEntity updateMenuById(UpdateMenuRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getMenuId() == null || entity.getMenuId().intValue() <= 0){
            return ResponseEntity.getFailEntity("menuId不能为空!");
        }
        if(entity.getMenuName() == null || "".equals(entity.getMenuName())){
            return ResponseEntity.getFailEntity("menuName不能为空!");
        }
        if(entity.getMenuDescribe() == null || "".equals(entity.getMenuDescribe())){
            return ResponseEntity.getFailEntity("menuDescribe不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        Menu menu = new Menu();
        menu.setMenuId(entity.getMenuId());//菜单id
        menu.setMenuName(entity.getMenuName());//菜单名称
        menu.setMenuDescribe(entity.getMenuDescribe());//菜单描述
        menu.setIsDisable(entity.getIsDisable());//启用禁用
        menu.setUpdateDatetime(currentDateTime);//修改时间
        int count = menuMapper.updateByPrimaryKeySelective(menu);//执行修改
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

}
