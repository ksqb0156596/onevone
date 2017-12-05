package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.util.QiniuUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
@RestController
public class FileUploadController {
    @Autowired
    private QiniuUtils qiniuUtils;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(@RequestParam(value = "file") MultipartFile file){
        try {
            return new ResultDTO<>(1,qiniuUtils.upload(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public Object uploads(@RequestParam(value = "files") MultipartFile [] files){
        try {
            List<String> list = new ArrayList<>();
            for(MultipartFile file : files){
                String name = qiniuUtils.upload(file);
                if(name == null){
                    return null;
                }
                list.add(name);
            }
            return list;
        }catch (Exception e){
            return null;
        }
    }
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public Object getToken() {
        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        jsonObject.put("uptoken",qiniuUtils.getToken());
        return jsonObject;
    }

}
