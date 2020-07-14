package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddOperRequestEntity;
import com.users.bean.request.QueryOperRequestEntity;
import com.users.bean.request.UpdateOperRequestEntity;
import com.users.common.RedisDisLocksCommon;
import com.users.service.OperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 18:08
 * @Description:操作元素控制器类
 */
@RestController
@RequestMapping("/oper")
public class OperController {

    @Autowired
    private OperService operService;
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/addoper",method = RequestMethod.POST)
    public ResponseEntity addOper(AddOperRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getOperCode() + entity.getOperName());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = operService.addOper(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/queryoperbycondition",method = RequestMethod.POST)
    public ResponseEntity queryOperByCondition(QueryOperRequestEntity entity){
        return operService.queryOperByCondition(entity);
    }

    @RequestMapping(value = "/deleteoperbyid",method = RequestMethod.POST)
    public ResponseEntity deleteOperById(@RequestParam(value = "id") Integer id){
        return operService.deleteOperById(id);
    }

    @RequestMapping(value = "/updateoperbyid",method = RequestMethod.POST)
    public ResponseEntity updateOperById(UpdateOperRequestEntity entity){
        return operService.updateOperById(entity);
    }

}
