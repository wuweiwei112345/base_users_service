package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.*;
import com.users.dao.mapper.FileMapper;
import com.users.dao.po.File;
import com.users.dao.po.FileExample;
import com.users.dao.po.Permission;
import com.users.dao.po.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 14:56
 * @Description:文件相关权限业务逻辑类
 */
@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;

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
    public ResponseEntity addFile(AddFileRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getFilePath() == null || "".equals(entity.getFilePath())){
            return ResponseEntity.getFailEntity("filePath不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        File file = new File();
        file.setFilePath(entity.getFilePath());//文件路径
        file.setIsDisable(entity.getIsDisable());//启用禁用
        file.setCreateDatetime(currentDateTime);//创建时间
        file.setUpdateDatetime(currentDateTime);//修改时间
        int count = fileMapper.insert(file);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

    /**
     * 条件查询文件路径数据
     * 功能描述: 条件查询文件路径数据
     * @param: entity 条件查询实体
     *     Integer fileId;//表记录主键id
     *     String filePath;//文件路径
     *     Integer isDisable;//0启用1禁用
     *     String createDatetimeStart;//创建时间
     *     String createDatetimeEnd;//创建时间
     *     String updateDatetimeStart;//最后修改时间
     *     String updateDatetimeEnd;//最后修改时间
     * @return: 权限数据集合
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity queryFileByCondition(QueryFileRequestEntity entity){
        FileExample example = new FileExample();
        //判断是否传入查询条件
        if(entity == null){
            List<File> list = fileMapper.selectByExample(example);
            return ResponseEntity.getSuccessEntityByListData(null,list);
        }
        //判断传入的查询条件并拼接
        FileExample.Criteria criteria = example.createCriteria();
        //表记录主键
        if(entity.getFileId() != null && entity.getFileId().intValue() > 0){
            criteria.andFileIdEqualTo(entity.getFileId());
        }
        //权限名称
        if(entity.getFilePath() != null && !("".equals(entity.getFilePath()))){
            criteria.andFilePathLike("%" + entity.getFilePath()  + "%");
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
        List<File> list = fileMapper.selectByExample(example);
        return ResponseEntity.getSuccessEntityByListData(null,list);
    }

    /**
     * 删除文件路径数据根据id
     * 功能描述: 删除文件路径数据根据id
     * @param: Integer id 主键id
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/6/28 16:27
     */
    public ResponseEntity deleteFileById(Integer id){
        //参数
        if(id == null || id.intValue() <= 0){
            return ResponseEntity.getFailEntity(null);
        }
        //执行删除
        int count = fileMapper.deleteByPrimaryKey(id);
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);//返回成功
        }else{
            return ResponseEntity.getFailEntity(null);//返回失败
        }
    }

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
    public ResponseEntity updateFileById(UpdateFileRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFailEntity("数据为空!");
        }
        if(entity.getFileId() == null || entity.getFileId().intValue() <= 0){
            return ResponseEntity.getFailEntity("fileId不能为空!");
        }
        if(entity.getFilePath() == null || "".equals(entity.getFilePath())){
            return ResponseEntity.getFailEntity("filePath不能为空!");
        }
        if(entity.getIsDisable() == null || !(entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            return ResponseEntity.getFailEntity("isDisable不能为空或需合法(0、1)!");
        }
        //执行数据操作
        Date currentDateTime = new Date();//获取当前服务器时间
        //构建添加数据实体
        File file = new File();
        file.setFileId(entity.getFileId());//文件id
        file.setFilePath(entity.getFilePath());//文件路径
        file.setIsDisable(entity.getIsDisable());//启用禁用
        file.setUpdateDatetime(currentDateTime);//修改时间
        int count = fileMapper.updateByPrimaryKey(file);//执行添加
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccessEntity(null);
        }else{
            return ResponseEntity.getFailEntity(null);
        }
    }

}
