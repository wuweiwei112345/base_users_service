package com.users.dao.mapper;

import com.users.dao.po.Role;
import com.users.dao.po.RoleExample;
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

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @SelectProvider(type=RoleSqlProvider.class, method="countByExample")
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @DeleteProvider(type=RoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @Delete({
        "delete from role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @Insert({
        "insert into role (role_id, role_name, ",
        "role_describe, is_disable, ",
        "create_datetime, update_datetime)",
        "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleDescribe,jdbcType=VARCHAR}, #{isDisable,jdbcType=INTEGER}, ",
        "#{createDatetime,jdbcType=TIMESTAMP}, #{updateDatetime,jdbcType=TIMESTAMP})"
    })
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @SelectProvider(type=RoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_describe", property="roleDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="isDisable", jdbcType=JdbcType.INTEGER),
        @Result(column="create_datetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_datetime", property="updateDatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "role_id, role_name, role_describe, is_disable, create_datetime, update_datetime",
        "from role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_describe", property="roleDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="isDisable", jdbcType=JdbcType.INTEGER),
        @Result(column="create_datetime", property="createDatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_datetime", property="updateDatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    Role selectByPrimaryKey(Integer roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated
     */
    @Update({
        "update role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "role_describe = #{roleDescribe,jdbcType=VARCHAR},",
          "is_disable = #{isDisable,jdbcType=INTEGER},",
          "create_datetime = #{createDatetime,jdbcType=TIMESTAMP},",
          "update_datetime = #{updateDatetime,jdbcType=TIMESTAMP}",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);
}