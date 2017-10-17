package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.WeddingPersonal;
import com.mk.onevone.service.WeddingPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 01436296 on 2017/10/12.
 */
@RestController
@RequestMapping(value = "/personal")
public class WeddingPersonalController {
    @Autowired
    private WeddingPersonalService weddingPersonalService;

    @RequestMapping(value = "/findList")
    public Object findList(WeddingPersonal weddingPersonal){
        return new ResultDTO<>(1,weddingPersonalService.findList(weddingPersonal));
    }

    @RequestMapping(value = "/get")
    public Object get(int id){
        return new ResultDTO<>(1,weddingPersonalService.get(id));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(WeddingPersonal weddingPersonal){
        return new ResultDTO<>(weddingPersonalService.save(weddingPersonal));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(Integer id){
        return new ResultDTO<>(weddingPersonalService.delete(id,9));
    }
}
