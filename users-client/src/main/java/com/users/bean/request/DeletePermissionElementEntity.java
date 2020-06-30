package com.users.bean.request;

import java.util.List;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 15:52
 * @Description:删除权限与元素关联关系参数实体
 */
public class DeletePermissionElementEntity {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
