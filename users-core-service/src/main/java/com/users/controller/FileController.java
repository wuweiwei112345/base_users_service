package com.users.controller;

import com.tools.entity.ResponseEntity;
import com.users.bean.request.AddFileRequestEntity;
import com.users.bean.request.QueryFileRequestEntity;
import com.users.bean.request.UpdateFileRequestEntity;
import com.users.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wuwei
 * @Date: 2020/6/29 16:06
 * @Description:文件相关权限控制器类
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/addfile",method = RequestMethod.POST)
    public ResponseEntity addFile(AddFileRequestEntity entity){
        return fileService.addFile(entity);
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
