package com.mk.onevone.controller;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.WeddingReserve;
import com.mk.onevone.service.WeddingReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reserve")
public class WeddingReserveController {
    @Autowired
    private WeddingReserveService weddingReserveService;

    @RequestMapping(value = "/get")
    public Object get(Integer personalId, String date){
        WeddingReserve weddingReserve = weddingReserveService.get(personalId,date);
        if(weddingReserve == null) {
            return new ResultDTO<>(0);
        }else {
            return new ResultDTO<>(1,weddingReserve);
        }
    }


    @RequestMapping(value = "/findList")
    public Object findList(WeddingReserve weddingReserve){
        return weddingReserveService.findList(weddingReserve);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object save(WeddingReserve weddingReserve){
        return weddingReserveService.save(weddingReserve);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable Integer id){
        return weddingReserveService.delete(id);
    }


}
