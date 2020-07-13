package com.users.service;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.tools.mgutil.MD5Utils;
import com.tools.mgutil.RegUtil;
import com.users.bean.request.*;
import com.users.common.RedisLoginTokenCommon;
import com.users.dao.mapper.UsersMapper;
import com.users.dao.po.Users;
import com.users.dao.po.UsersExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wuwei
 * @Date: 2020/7/11 10:58
 * @Description:用户业务逻辑类
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisLoginTokenCommon redisLoginTokenCommon;

    /**
     * 注册用户信息
     * 功能描述:注册用户信息
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @param: Integer isAdmin;//是否是管理员 0非管理员 1管理员
     * @return: 是否注册成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity registerUserInfo(RegisterUserInfoRequestEntity entity){
        //验证参数
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getUserName() == null || "".equals(entity.getUserName())){
            return ResponseEntity.getFail("userName参数为必选!");
        }
        if(entity.getUserPassword() == null || "".equals(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数为必选!");
        }
        if(RegUtil.isAdapterPassword(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数需合法!");
        }
        if(entity.getUserPhonenum() == null || "".equals(entity.getUserPhonenum())){
            return ResponseEntity.getFail("userPhonenum参数为必选!");
        }
        //检查排重
        SelectUsersListByConditionRequestEntity queryEntity = new SelectUsersListByConditionRequestEntity();
        queryEntity.setUserName(entity.getUserName());
        ResponseEntity responseEntity = this.selectUsersListByCondition(queryEntity);
        if(!(CollectionUtils.isEmpty(responseEntity.getDataList()))){
            return ResponseEntity.getFailAndCode("重复添加!",100002);
        }
        //将密码进行MD5加密
        String userPasswordByMD5 = MD5Utils.getMD5(entity.getUserPassword());
        //构建用户信息实体
        Users user = new Users();
        user.setUserName(entity.getUserName());
        user.setUserPassword(userPasswordByMD5);
        user.setIsDisable(0);//0未禁用
        user.setIsAdmin(entity.getIsAdmin());//0非管理员 1管理员
        user.setCreateDatetime(new Date());
        //执行用户添加
        int count = usersMapper.insert(user);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

    /**
     * 用户登录
     * 功能描述: 用户登录
     * @param: String userName;//用户名
     * @param: String userPassword;//用户密码
     * @return: 统一响应实体 用户登录token
     * @auther: wuwei
     * @date: 2020/7/11 15:26
     */
    public ResponseEntity login(LoginRequestEntity entity){
        //参数检查
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(StringUtils.isBlank(entity.getUserName())){
            return ResponseEntity.getFail("userName参数为必选!");
        }
        if(StringUtils.isBlank(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数为必选!");
        }
        if(RegUtil.isAdapterPassword(entity.getUserPassword())){
            return ResponseEntity.getFail("userPassword参数需合法!");
        }
        //查询用户
        UsersExample example = new UsersExample();
        example.or().andUserNameEqualTo(entity.getUserName());
        example.or().andUserEmailEqualTo(entity.getUserName());
        example.or().andUserPhonenumEqualTo(entity.getUserName());
        List<Users> list = usersMapper.selectByExample(example);
        //解析集合
        if(!CollectionUtils.isEmpty(list)){
            Users users = list.get(0);
            //判断密码是否一致
            if(MD5Utils.getMD5(entity.getUserPassword()).equals(users.getUserPassword())){
                String userId = users.getUserId().toString();
                //生成用户登录token
                String token = redisLoginTokenCommon.createLoginUser(userId);
                //设置token到redis数据库
                boolean bool = redisLoginTokenCommon.setLoginToken(userId,token);
                //组装返回数据
                Map<String,String> resultMap = new HashMap<String,String>();
                resultMap.put("userId",userId);
                resultMap.put("token",token);
                return ResponseEntity.getSuccessByEntity("登录成功!",resultMap);
            }else{
                return ResponseEntity.getFail("用户密码错误!");
            }
        }else{
            return ResponseEntity.getFail("没有此用户!");
        }
    }

    /**
     * 注册用户信息
     * 功能描述:注册用户信息
     * @param: Integer userId;//用户id
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @param: Integer isAdmin;//是否是管理员 0非管理员 1管理员
     * @return: 是否修改成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity updateUserInfoByUserId(UpdateUserInfoByIdRequestEntity entity){
        //验证参数
        if(entity == null){
            return ResponseEntity.getFail("请传入参数!");
        }
        if(entity.getUserId() == null || entity.getUserId().intValue() <= 0){
            return ResponseEntity.getFail("userId参数为必选!");
        }
        //构建修改用户信息实体
        Users user = new Users();
        user.setUserId(entity.getUserId());
        //判断是否需要修改用户密码
        if(entity.getUserPassword() != null && !("".equals(entity.getUserPassword())) && RegUtil.isAdapterPassword(entity.getUserPassword())){
            //将密码进行MD5加密
            String userPasswordByMD5 = MD5Utils.getMD5(entity.getUserPassword());
            user.setUserPassword(userPasswordByMD5);
        }
        //判断是否需要修改用户手机号码
        if(entity.getUserPhonenum() != null && !("".equals(entity.getUserPhonenum()))){
            user.setUserPhonenum(entity.getUserPhonenum());
        }
        //判断是否需要修改用户邮箱
        if(entity.getUserEmail() != null && !("".equals(entity.getUserEmail()))){
            user.setUserEmail(entity.getUserEmail());
        }
        //判断是否需要修改是否是管理员属性值
        if(entity.getIsAdmin() != null && (entity.getIsAdmin() == 0 || entity.getIsAdmin() == 1)){
            user.setIsAdmin(entity.getIsAdmin());//0非管理员 1管理员
        }
        //判断是否需要修改是否启用禁用
        if(entity.getIsDisable() != null && (entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            user.setIsDisable(entity.getIsDisable());//0启用 1禁用
        }
        //执行用户信息修改
        int count = usersMapper.updateByPrimaryKeySelective(user);
        //返回逻辑
        if(count > 0){
            return ResponseEntity.getSuccess(null);
        }else{
            return ResponseEntity.getFail(null);
        }
    }

    /**
     * 用户启用
     * 功能描述:用户启用
     * @param: Integer userId;//用户id
     * @return: 是否启用成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity activateByUserId(Integer userId){
        //验证参数
        if(userId == null || userId <= 0){
            return ResponseEntity.getFail("userId参数为必选!");
        }
        //调用用户信息修改方法
        UpdateUserInfoByIdRequestEntity entity = new UpdateUserInfoByIdRequestEntity();
        entity.setUserId(userId);
        entity.setIsDisable(0);//0启用
        return this.updateUserInfoByUserId(entity);
    }

    /**
     * 用户禁用
     * 功能描述:用户禁用
     * @param: Integer userId;//用户id
     * @return: 是否禁用成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity disableByUserId(Integer userId){
        //验证参数
        if(userId == null || userId <= 0){
            return ResponseEntity.getFail("userId参数为必选!");
        }
        //调用用户信息修改方法
        UpdateUserInfoByIdRequestEntity entity = new UpdateUserInfoByIdRequestEntity();
        entity.setUserId(userId);
        entity.setIsDisable(1);//1禁用
        return this.updateUserInfoByUserId(entity);
    }

    /**
     * 设置用户为管理员根据用户id
     * 功能描述:设置用户为管理员根据用户id
     * @param: Integer userId;//用户id
     * @return: 是否设置成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity setAdminByUserId(Integer userId){
        //验证参数
        if(userId == null || userId <= 0){
            return ResponseEntity.getFail("userId参数为必选!");
        }
        //调用用户信息修改方法
        UpdateUserInfoByIdRequestEntity entity = new UpdateUserInfoByIdRequestEntity();
        entity.setUserId(userId);
        entity.setIsAdmin(1);//1用户为管理员
        return this.updateUserInfoByUserId(entity);
    }

    /**
     * 取消用户为管理员根据用户id
     * 功能描述:取消用户为管理员根据用户id
     * @param: Integer userId;//用户id
     * @return: 是否取消成功 true成功 false失败
     * @auther: wuwei
     * @date: 2020/7/11 11:03
     */
    public ResponseEntity cancelAdminByUserId(Integer userId){
        //验证参数
        if(userId == null || userId <= 0){
            return ResponseEntity.getFail("userId参数为必选!");
        }
        //调用用户信息修改方法
        UpdateUserInfoByIdRequestEntity entity = new UpdateUserInfoByIdRequestEntity();
        entity.setUserId(userId);
        entity.setIsAdmin(0);//0用户为管理员
        return this.updateUserInfoByUserId(entity);
    }

    /**
     * 用户信息条件查询请求参数类
     * 功能描述: 用户信息条件查询请求参数类
     * @param: Integer userId;//表记录主键id
     * @param: String userName;//用户名(登录使用)
     * @param: String userPhonenum;//用户手机号(登录使用)
     * @param: String userEmail;//用户邮箱(登录使用)
     * @param: String userPassword;//用户密码(MD5加密结果)
     * @param: Integer isDisable;//0启用1禁用
     * @param: Integer isAdmin;//0非管理员 1管理员
     * @param: String createDatetimeStart;//创建时间起始
     * @param: String createDatetimeEnd;//创建时间结束
     * @return: 统一响应实体
     * @auther: wuwei
     * @date: 2020/7/11 21:52
     */
    public ResponseEntity selectUsersListByCondition(SelectUsersListByConditionRequestEntity entity){
        //实例化查询条件类
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();

        if(entity.getUserId() != null && entity.getUserId() > 0){
            criteria.andUserIdEqualTo(entity.getUserId());//表记录主键id
        }
        if(entity.getUserName() != null && !("".equals(entity.getUserName()))){
            criteria.andUserNameLike("%" + entity.getUserName() + "%");
        }
        if(entity.getUserPhonenum() != null && !("".equals(entity.getUserPhonenum()))){
            criteria.andUserPhonenumEqualTo(entity.getUserPhonenum());
        }
        if(entity.getUserEmail() != null && !("".equals(entity.getUserEmail()))){
            criteria.andUserEmailEqualTo(entity.getUserEmail());
        }
        if(entity.getIsDisable() != null && (entity.getIsDisable() == 0 || entity.getIsDisable() == 1)){
            criteria.andIsDisableEqualTo(entity.getIsDisable());
        }
        if(entity.getIsAdmin() != null && (entity.getIsAdmin() == 0 || entity.getIsAdmin() == 1)){
            criteria.andIsAdminEqualTo(entity.getIsAdmin());
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
        //执行查询
        List<Users> list = usersMapper.selectByExample(usersExample);
        //返回数据
        return ResponseEntity.getSuccessByEntity(null,list);
    }

}
