package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.AddOperRequestEntity;
import com.users.bean.request.QueryMenuRequestEntity;
import com.users.bean.request.QueryOperRequestEntity;
import com.users.bean.request.UpdateOperRequestEntity;
import com.users.dao.mapper.OperMapper;
import com.users.dao.po.Oper;
import com.users.dao.po.OperExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 17:06
 * @Description:操作元素业务逻辑类
 */
@Service
public class OperService {

    @Autowired
    private OperMapper operMapper;

    /**
     * 添加操作元素数据
     * 功能描述: 添加操作元素数据
     * @param: entity 添加操作元素数据请求参数实体
     *     String operName;//操作名称
     *     String operCode;//操作简码
     *     String operUrl;//操作url(可预设参数预留参数位)
     *     Integer parentOperId;//父操作id
     *     Integer isDisable;//启用1禁用
     * @return: 
     * @auther: wuwei
     * @date: 2020/6/30 17:13
     */
    public ResponseEntity addOper(AddOperRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getOperName() == null || "".equals(entity.getOperName())){
            return ResponseEntity.getFail("operName参数为必选!");
        }
        if(entity.getOperCode() == null || "".equals(entity.getOperCode())){
            return ResponseEntity.getFail("operCode参数为必选!");
        }
        if(entity.getOperUrl() == null || "".equals(entity.getOperUrl())){
            return ResponseEntity.getFail("operUrl参数为必选!");
        }
        if(entity.getParentOperId() == null || entity.getParentOperId().intValue() < 0){
            entity.setParentOperId(0);//设置默认为0
        }
        if(entity.getIsDisable() == null ||
                !(entity.getIsDisable().intValue() == 0 ||
                entity.getIsDisable().intValue() == 1)){
            return ResponseEntity.getFail("isDisable参数为必选!");
        }
        //检查排重
        QueryOperRequestEntity queryEntity = new QueryOperRequestEntity();
        queryEntity.setParentOperId(entity.getParentOperId());
        queryEntity.setOperName(entity.getOperName());
        queryEntity.setOperCode(entity.getOperCode());
        queryEntity.setOperUrl(entity.getOperUrl());
        ResponseEntity responseEntity = this.queryOperByCondition(queryEntity);
        if(!(CollectionUtils.isEmpty(responseEntity.getDataList()))){
            return ResponseEntity.getFailAndCode("重复添加!",100002);
        }
        //执行添加
        Date currentDateTime = new Date();
        Oper oper = new Oper();//实例化操作数据实体
        oper.setOperName(entity.getOperName());//操作名称
        oper.setOperCode(entity.getOperCode());//操作简码
        oper.setOperUrl(entity.getOperUrl());//操作url(可预设参数预留参数位)
        oper.setParentOperId(entity.getParentOperId());//父操作id（为0表示没有）
        oper.setIsDisable(entity.getIsDisable());//0启用1禁用
        oper.setCreateDatetime(currentDateTime);//创建时间
        oper.setUpdateDatetime(currentDateTime);//最后修改时间
        int count = operMapper.insert(oper);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

    public ResponseEntity queryOperByCondition(QueryOperRequestEntity entity){
        OperExample operExample = new OperExample();
        //判断是否直接查询所有
        if(entity == null){
            //执行查询
            List<Oper> list = operMapper.selectByExample(operExample);
            //返回数据
            return ResponseEntity.getSuccessByListData(null,list);
        }
        //拼接查询条件
        OperExample.Criteria criteria = operExample.createCriteria();
        if(entity.getOperId() != null && entity.getOperId().intValue() > 0){
            criteria.andOperIdEqualTo(entity.getOperId());
        }
        if(entity.getOperName() != null && !"".equals(entity.getOperName())){
            criteria.andOperNameLike("%" + entity.getOperName() + "%");
        }
        if(entity.getOperCode() != null && !"".equals(entity.getOperCode())){
            criteria.andOperCodeLike("%" + entity.getOperCode() + "%");
        }
        if(entity.getOperUrl() != null && !"".equals(entity.getOperUrl())){
            criteria.andOperUrlLike("%" + entity.getOperUrl() + "%");
        }
        if(entity.getParentOperId() != null && entity.getParentOperId().intValue() <= 0){
            criteria.andParentOperIdEqualTo(entity.getParentOperId());
        }
        if(entity.getIsDisable() != null && entity.getIsDisable().intValue() <= 0){
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
        List<Oper> list = operMapper.selectByExample(operExample);
        //返回数据
        return ResponseEntity.getSuccessByListData(null,list);
    }

    /**
     * 删除操作元素根据主键id
     * 功能描述: 删除操作元素根据主键id
     * @param: id 主键id
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/30 17:52
     */
    public ResponseEntity deleteOperById(Integer id){
        //参数检查
        if(id == null || id.intValue() <= 0){
            return ResponseEntity.getFail("id参数为必选!");
        }
        //执行删除
        int count = operMapper.deleteByPrimaryKey(id);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

    /**
     * 修改操作元素数据根据主键id
     * 功能描述:修改操作元素数据根据主键id
     * @param: entity 修改操作请求参数实体
     *     Integer operId;//表记录主键id
     *     String operName;//操作名称
     *     String operCode;//操作简码
     *     String operUrl;//操作url(可预设参数预留参数位)
     *     Integer parentOperId;//父操作id（为0表示没有）
     *     Integer isDisable;//0启用1禁用
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/30 18:00
     */
    public ResponseEntity updateOperById(UpdateOperRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getOperId() == null || entity.getOperId().intValue() <= 0){
            return ResponseEntity.getFail("operId参数为必选!");
        }
        if(entity.getOperName() == null || "".equals(entity.getOperName())){
            return ResponseEntity.getFail("operName参数为必选!");
        }
        if(entity.getOperCode() == null || "".equals(entity.getOperCode())){
            return ResponseEntity.getFail("operCode参数为必选!");
        }
        if(entity.getOperUrl() == null || "".equals(entity.getOperUrl())){
            return ResponseEntity.getFail("operUrl参数为必选!");
        }
        if(entity.getParentOperId() == null || entity.getParentOperId().intValue() < 0){
            return ResponseEntity.getFail("parentOperId参数为必选!");
        }
        if(entity.getIsDisable() == null ||
                !(entity.getIsDisable().intValue() == 0 ||
                        entity.getIsDisable().intValue() == 1)){
            return ResponseEntity.getFail("isDisable参数为必选!");
        }
        //执行添加
        Date currentDateTime = new Date();
        Oper oper = new Oper();//实例化操作数据实体
        oper.setOperId(entity.getOperId());//主键id
        oper.setOperName(entity.getOperName());//操作名称
        oper.setOperCode(entity.getOperCode());//操作简码
        oper.setOperUrl(entity.getOperUrl());//操作url(可预设参数预留参数位)
        oper.setParentOperId(entity.getParentOperId());//父操作id（为0表示没有）
        oper.setIsDisable(entity.getIsDisable());//0启用1禁用
        oper.setUpdateDatetime(currentDateTime);//最后修改时间
        int count = operMapper.updateByPrimaryKeySelective(oper);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

}
