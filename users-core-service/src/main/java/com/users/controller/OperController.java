package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.tools.mgutil.DateTimeUtil;
import com.users.bean.request.AddOperRequestEntity;
import com.users.bean.request.QueryOperRequestEntity;
import com.users.bean.request.UpdateOperRequestEntity;
import com.users.dao.po.Oper;
import com.users.dao.po.OperExample;
import com.users.service.OperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/addoper",method = RequestMethod.POST)
    public ResponseEntity addOper(AddOperRequestEntity entity){
        return operService.addOper(entity);
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
