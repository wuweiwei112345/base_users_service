package com.users.dao.mapper;

import com.users.dao.po.RolePermission;
import com.users.dao.po.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @SelectProvider(type=RolePermissionSqlProvider.class, method="countByExample")
    long countByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @DeleteProvider(type=RolePermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @Delete({
        "delete from role_permission",
        "where role_permission_id = #{rolePermissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @Insert({
        "insert into role_permission (role_permission_id, role_id, ",
        "permission_id)",
        "values (#{rolePermissionId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{permissionId,jdbcType=INTEGER})"
    })
    int insert(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @InsertProvider(type=RolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @SelectProvider(type=RolePermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_permission_id", property="rolePermissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER)
    })
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "role_permission_id, role_id, permission_id",
        "from role_permission",
        "where role_permission_id = #{rolePermissionId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="role_permission_id", property="rolePermissionId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER)
    })
    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RolePermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
     *
     * @mbg.generated
     */
    @Update({
        "update role_permission",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "permission_id = #{permissionId,jdbcType=INTEGER}",
        "where role_permission_id = #{rolePermissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RolePermission record);
}