package com.mk.onevone.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mk.onevone.dao.WeddingRecommendDAO;
import com.mk.onevone.entity.WeddingPersonal;
import com.mk.onevone.entity.WeddingRecommend;
import com.mk.onevone.service.WeddingRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
@Service
public class WeddingRecommendServiceImpl implements WeddingRecommendService{

    @Autowired
    private WeddingRecommendDAO weddingRecommendDAO;

    @Override
    public int save(WeddingRecommend weddingRecommend) {
        if(weddingRecommendDAO.findList(weddingRecommend).size() > 0) {
            return -1;
        }
        if(weddingRecommend.getId() == null) {
            return weddingRecommendDAO.insert(weddingRecommend);
        }
        return weddingRecommendDAO.updateByPrimaryKeySelective(weddingRecommend);
    }

    @Override
    public int delete(int id, int status) {
        return weddingRecommendDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPersonId(int id) {
        return weddingRecommendDAO.deleteByPersonId(id);
    }

    @Override
    public List<WeddingRecommend> findList(WeddingRecommend weddingRecommend) {
        return weddingRecommendDAO.findList(weddingRecommend);
    }

    @Override
    public List findRecommendList(int type) {
        if(type == 0){
            return weddingRecommendDAO.findRecommendByGroup();
        }else if(type == 1){
            return weddingRecommendDAO.findRecommendByPerson();
        }
        return new ArrayList();
    }

    @Override
    public WeddingRecommend get(int id) {
        return weddingRecommendDAO.selectByPrimaryKey(id);
    }

    @Override
    public JSONObject findRecommendByPersonal() {
        List<WeddingPersonal> list = weddingRecommendDAO.findRecommendByPerson();
        JSONObject jsonObject = new JSONObject();
        for(WeddingPersonal weddingPersonal : list){
            String type = String.valueOf(weddingPersonal.getType());
            if(jsonObject.containsKey(type)){
                JSONArray jsonArray = jsonObject.getJSONArray(type);
                jsonArray.add(weddingPersonal);
            }else{
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(weddingPersonal);
                jsonObject.put(type, jsonArray);
            }
        }
        return jsonObject;
    }
}
