package com.mk.onevone.service.impl;

import com.mk.onevone.dao.WeddingPersonalDAO;
import com.mk.onevone.entity.WeddingPersonal;
import com.mk.onevone.service.WeddingPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
@Service
public class WeddingPersonalServiceImpl implements WeddingPersonalService{
    @Autowired
    private WeddingPersonalDAO weddingPersonalDAO;

    @Override
    public int save(WeddingPersonal weddingPersonal) {
        if(weddingPersonal.getId() == null)
            return weddingPersonalDAO.insert(weddingPersonal);
        return weddingPersonalDAO.updateByPrimaryKeySelective(weddingPersonal);
    }

    @Override
    public int delete(int id, int status) {
        return weddingPersonalDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<WeddingPersonal> findList(WeddingPersonal weddingPersonal) {
        return weddingPersonalDAO.findList(weddingPersonal);
    }

    @Override
    public WeddingPersonal get(int id) {
        return weddingPersonalDAO.selectByPrimaryKey(id);
    }
}
