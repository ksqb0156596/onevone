package com.mk.onevone.controller;

import com.mk.onevone.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 01436296 on 2017/10/12.
 */
@RestController
public class FileUploadController {
    @Autowired
    private QiniuUtils qiniuUtils;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file){
        return qiniuUtils.upload(file);
    }

}
