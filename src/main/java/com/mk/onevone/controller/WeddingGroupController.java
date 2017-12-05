package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.WeddingGroup;
import com.mk.onevone.service.WeddingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findListByPage")
    public Object findList(WeddingGroup weddingGroup,Integer pageNum,Integer pageSize){
        return new ResultDTO<>(1,weddingGroupService.findList(weddingGroup,pageNum,pageSize));
    }

    @RequestMapping(value = "/get")
    public Object get(int id){
        return new ResultDTO<>(1,weddingGroupService.get(id));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(@RequestBody WeddingGroup weddingGroup){
        return new ResultDTO<>(weddingGroupService.save(weddingGroup));
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer id){
        return new ResultDTO<>(weddingGroupService.delete(id,9));
    }
}
