package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddMenuRequestEntity;
import com.users.bean.request.QueryMenuRequestEntity;
import com.users.bean.request.UpdateMenuRequestEntity;
import com.users.common.RedisDisLocksCommon;
import com.users.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 18:02
 * @Description:菜单数据控制类
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/addmenu",method = RequestMethod.POST)
    public ResponseEntity addMenu(AddMenuRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getMenuParentId() + entity.getMenuName());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = menuService.addMenu(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/querymenubycondition",method = RequestMethod.POST)
    public ResponseEntity queryMenuByCondition(QueryMenuRequestEntity entity){
        return menuService.queryMenuByCondition(entity);
    }

    @RequestMapping(value = "/deletemenubyid",method = RequestMethod.POST)
    public ResponseEntity deleteMenuById(@RequestParam(value = "id") Integer id){
        return menuService.deleteMenuById(id);
    }

    @RequestMapping(value = "/updatemenubyid",method = RequestMethod.POST)
    public ResponseEntity updateMenuById(UpdateMenuRequestEntity entity){
        return menuService.updateMenuById(entity);
    }

}
