package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddPageElementRequestEntity;
import com.users.bean.request.QueryPageElementRequestEntity;
import com.users.bean.request.UpdatePageElementRequestEntity;
import com.users.common.RedisDisLocksCommon;
import com.users.service.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/30 19:10
 * @Description: 页面元素业务控制器类
 */
@RestController
@RequestMapping("/pageelement")
public class PageElementController {

    @Autowired
    private PageElementService pageElementService;
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/addpageelement",method = RequestMethod.POST)
    public ResponseEntity addPageElement(AddPageElementRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getPageElementCode());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = pageElementService.addPageElement(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/queryfilebycondition",method = RequestMethod.POST)
    public ResponseEntity queryFileByCondition(QueryPageElementRequestEntity entity){
        return pageElementService.queryFileByCondition(entity);
    }

    @RequestMapping(value = "/deletepageelementbyid",method = RequestMethod.POST)
    public ResponseEntity deletePageElementById(Integer id){
        return pageElementService.deletePageElementById(id);
    }

    @RequestMapping(value = "/updatepageelementbyid",method = RequestMethod.POST)
    public ResponseEntity updatePageElementById(UpdatePageElementRequestEntity entity){
        return pageElementService.updatePageElementById(entity);
    }

}
