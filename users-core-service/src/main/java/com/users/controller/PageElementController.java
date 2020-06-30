package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddPageElementRequestEntity;
import com.users.bean.request.QueryPageElementRequestEntity;
import com.users.bean.request.UpdatePageElementRequestEntity;
import com.users.service.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/addpageelement",method = RequestMethod.POST)
    public ResponseEntity addPageElement(AddPageElementRequestEntity entity){
        return pageElementService.addPageElement(entity);
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
