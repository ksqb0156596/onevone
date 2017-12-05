package com.mk.onevone.service;

import com.github.pagehelper.PageInfo;
import com.mk.onevone.entity.WeddingPersonal;

import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
public interface WeddingPersonalService {
    int save(WeddingPersonal weddingPersonal);
    int delete(int id,int status);
    List<WeddingPersonal> findList(WeddingPersonal weddingPersonal);
    PageInfo<WeddingPersonal> findList(WeddingPersonal weddingPersonal, Integer pageNum, Integer pageSize);
    WeddingPersonal get(int id);
    List<WeddingPersonal> findListByRecommend(String ids);
}
