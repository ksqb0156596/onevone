package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.WeddingGroup;
import com.mk.onevone.service.WeddingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 01436296 on 2017/10/12.
 */
@RestController
@RequestMapping(value = "/group")
public class WeddingGroupController {
    @Autowired
    private WeddingGroupService weddingGroupService;
    @RequestMapping(value = "/findList")
    public Object findList(WeddingGroup weddingGroup){
        return new ResultDTO<>(1,weddingGroupService.findList(weddingGroup));
    }

    @RequestMapping(value = "/get")
    public Object get(int id){
        return new ResultDTO<>(1,weddingGroupService.get(id));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(WeddingGroup weddingGroup){
        return new ResultDTO<>(weddingGroupService.save(weddingGroup));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(Integer id){
        return new ResultDTO<>(weddingGroupService.delete(id,9));
    }
}
