package com.users.dao.po;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbg.generated
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_describe
     *
     * @mbg.generated
     */
    private String roleDescribe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.is_disable
     *
     * @mbg.generated
     */
    private Integer isDisable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_datetime
     *
     * @mbg.generated
     */
    private Date createDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_datetime
     *
     * @mbg.generated
     */
    private Date updateDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_describe
     *
     * @return the value of role.role_describe
     *
     * @mbg.generated
     */
    public String getRoleDescribe() {
        return roleDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_describe
     *
     * @param roleDescribe the value for role.role_describe
     *
     * @mbg.generated
     */
    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.is_disable
     *
     * @return the value of role.is_disable
     *
     * @mbg.generated
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.is_disable
     *
     * @param isDisable the value for role.is_disable
     *
     * @mbg.generated
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_datetime
     *
     * @return the value of role.create_datetime
     *
     * @mbg.generated
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_datetime
     *
     * @param createDatetime the value for role.create_datetime
     *
     * @mbg.generated
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_datetime
     *
     * @return the value of role.update_datetime
     *
     * @mbg.generated
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_datetime
     *
     * @param updateDatetime the value for role.update_datetime
     *
     * @mbg.generated
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}