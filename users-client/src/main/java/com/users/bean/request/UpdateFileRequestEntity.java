package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 15:57
 * @Description:修改文件元素请求数据实体
 */
public class UpdateFileRequestEntity extends RequestBaseEntity {

    private Integer fileId;//表记录主键id
    private String filePath;//文件路径
    private Integer isDisable;//0启用1禁用

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

}
