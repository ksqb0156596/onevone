package com.mk.onevone.service.impl;

import com.mk.onevone.dao.WeddingRecommendDAO;
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
}
