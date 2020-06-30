package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.AddPageElementRequestEntity;
import com.users.bean.request.QueryFileRequestEntity;
import com.users.bean.request.QueryPageElementRequestEntity;
import com.users.bean.request.UpdatePageElementRequestEntity;
import com.users.dao.mapper.PageElementMapper;
import com.users.dao.po.File;
import com.users.dao.po.FileExample;
import com.users.dao.po.PageElement;
import com.users.dao.po.PageElementExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 19:09
 * @Description:页面元素业务逻辑类
 */
@Service
public class PageElementService {

    @Autowired
    private PageElementMapper pageElementMapper;

    /**
     * 添加页面元素方法
     * 功能描述: 添加页面元素方法
     * @param: entity 添加页面元素请求参数实体
     *      String pageElementCode;//页面元素英文简码
     *      Integer isDisable;//0启用1禁用
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/30 19:19
     */
    public ResponseEntity addPageElement(AddPageElementRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getPageElementCode() == null || "".equals(entity.getPageElementCode())){
            return ResponseEntity.getFailEntity("pageElementCode不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        PageElement pageElement = new PageElement();
        pageElement.setPageElementCode(entity.getPageElementCode());
        pageElement.setIsDisable(entity.getIsDisable());
        pageElement.setCreateDatetime(currentDateTime);
        pageElement.setUpdateDatetime(currentDateTime);
        int count = pageElementMapper.insert(pageElement);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

    /**
     * 条件查询页面元素方法
     * 功能描述: 条件查询页面元素方法
     * @param: entity 条件查询页面元素实体
     *     Integer pageElementId;//表记录主键id
     *     String pageElementCode;//页面元素英文简码
     *     Integer isDisable;//0启用1禁用
     *     String createDatetimeStart;//创建时间
     *     String createDatetimeEnd;//创建时间
     *     String updateDatetimeStart;//最后修改时间
     *     String updateDatetimeEnd;//最后修改时间
     * @return: 权限数据集合
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity queryFileByCondition(QueryPageElementRequestEntity entity){
        PageElementExample example = new PageElementExample();
        //判断是否传入查询条件
        if(entity == null){
            List<PageElement> list = pageElementMapper.selectByExample(example);
            return ResponseEntity.getSuccessEntityByListData(null,list);
        }
        //判断传入的查询条件并拼接
        PageElementExample.Criteria criteria = example.createCriteria();
        if(entity.getPageElementId() != null && entity.getPageElementId().intValue() > 0){
            criteria.andPageElementIdEqualTo(entity.getPageElementId());
        }
        if(entity.getPageElementCode() != null && !("".equals(entity.getPageElementCode()))){
            criteria.andPageElementCodeLike("%" + entity.getPageElementCode()  + "%");
        }
        if(entity.getIsDisable() != null && entity.getIsDisable() > 0){
            criteria.andIsDisableEqualTo(entity.getIsDisable());
        }
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
        List<PageElement> list = pageElementMapper.selectByExample(example);
        return ResponseEntity.getSuccessEntityByListData(null,list);
    }

    /**
     * 删除页面元素根据主键id
     * 功能描述: 删除页面元素根据主键id
     * @param: String id;//主键id
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/30 19:32
     */
    public ResponseEntity deletePageElementById(Integer id){
        //参数
        if(id == null || id.intValue() <= 0){
            return ResponseEntity.getFailEntity(null);
        }
        //执行删除
        int count = pageElementMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);//返回成功
        }else{
            return ResponseEntity.getFailEntity(null);//返回失败
        }
    }

    /**
     * 修改页面元素方法
     * 功能描述: 修改页面元素方法
     * @param: entity 修改页面元素请求参数实体
     *      Integer pageElementId;//表记录主键id
     *      String pageElementCode;//页面元素英文简码
     *      Integer isDisable;//0启用1禁用
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/30 19:19
     */
    public ResponseEntity updatePageElementById(UpdatePageElementRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getPageElementId() == null || entity.getPageElementId().intValue() < 0){
            return ResponseEntity.getFailEntity("pageElementId不能为空!");
        }
        if(entity.getPageElementCode() == null || "".equals(entity.getPageElementCode())){
            return ResponseEntity.getFailEntity("pageElementCode不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        PageElement pageElement = new PageElement();
        pageElement.setPageElementId(entity.getPageElementId());
        pageElement.setPageElementCode(entity.getPageElementCode());
        pageElement.setIsDisable(entity.getIsDisable());
        pageElement.setUpdateDatetime(currentDateTime);
        int count = pageElementMapper.updateByPrimaryKeySelective(pageElement);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

}
