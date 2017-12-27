package com.mk.onevone.service;

import com.alibaba.fastjson.JSONObject;
import com.mk.onevone.entity.WeddingRecommend;

import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
public interface WeddingRecommendService {
    int save(WeddingRecommend weddingRecommend);
    int delete(int id,int status);
    int deleteByPersonId(int id);
    List<WeddingRecommend> findList(WeddingRecommend weddingRecommend);
    List findRecommendList(int type);
    WeddingRecommend get(int id);
    JSONObject findRecommendByPersonal();
}
