package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.WeddingRecommend;
import com.mk.onevone.service.WeddingRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 01436296 on 2017/10/12.
 */
@RestController
@RequestMapping(value = "recommend")
public class WeddingRecommendController {
    
    @Autowired
    private WeddingRecommendService weddingRecommendService;


    @RequestMapping(value = "/findList")
    public Object findList(WeddingRecommend weddingRecommend){
        return new ResultDTO<>(1,weddingRecommendService.findList(weddingRecommend));
    }
    @RequestMapping(value = "/findRecommendList")
    public Object findRecommendList(int type){
        return new ResultDTO<>(1,weddingRecommendService.findRecommendList(type));
    }

    @RequestMapping(value = "/get")
    public Object get(int id){
        return new ResultDTO<>(1,weddingRecommendService.get(id));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(WeddingRecommend weddingRecommend){
        return new ResultDTO<>(weddingRecommendService.save(weddingRecommend));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(Integer id){
        return new ResultDTO<>(weddingRecommendService.delete(id,9));
    }
}
