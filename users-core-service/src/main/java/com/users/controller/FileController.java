package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddFileRequestEntity;
import com.users.bean.request.QueryFileRequestEntity;
import com.users.bean.request.UpdateFileRequestEntity;
import com.users.common.RedisDisLocksCommon;
import com.users.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 16:06
 * @Description: 文件相关权限控制器类
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/addfile",method = RequestMethod.POST)
    public ResponseEntity addFile(AddFileRequestEntity entity){
        //实例化锁工具类
        RedisDisLocksCommon redisDisLocksCommon = new RedisDisLocksCommon(template,entity.getFilePath());
        //尝试获取锁
        boolean bool = redisDisLocksCommon.getLock();
        //准备返回结果
        ResponseEntity responseEntity = ResponseEntity.getFail("失败!");
        if(bool){
            //执行业务逻辑方法
            responseEntity = fileService.addFile(entity);
            //取消锁
            redisDisLocksCommon.cancelLock();
        }
        return responseEntity;
    }

    @RequestMapping(value = "/queryfilebycondition",method = RequestMethod.POST)
    public ResponseEntity queryFileByCondition(QueryFileRequestEntity entity){
        return fileService.queryFileByCondition(entity);
}

    @RequestMapping(value = "/deletefilebyid",method = RequestMethod.POST)
    public ResponseEntity deleteFileById(@RequestParam(value = "id") Integer id){
        return fileService.deleteFileById(id);
    }

    @RequestMapping(value = "/updatefilebyid",method = RequestMethod.POST)
    public ResponseEntity updateFileById(UpdateFileRequestEntity entity){
        return fileService.updateFileById(entity);
    }

}
