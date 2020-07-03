package com.users.bean.request;

import com.tools.entity.RequestBaseEntity;
import java.util.Date;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 15:56
 * @Description:添加文件元素请求数据实体
 */
public class AddFileRequestEntity extends RequestBaseEntity {

    private String filePath;//文件路径
    private Integer isDisable;//0启用1禁用
    private Date createDatetime;//创建时间
    private Date updateDatetime;//最后修改时间

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

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
