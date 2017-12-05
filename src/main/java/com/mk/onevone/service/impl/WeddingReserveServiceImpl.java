package com.mk.onevone.service.impl;

import com.mk.onevone.dao.WeddingReserveDAO;
import com.mk.onevone.entity.WeddingReserve;
import com.mk.onevone.service.WeddingReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingReserveServiceImpl implements WeddingReserveService {

    @Autowired
    private WeddingReserveDAO weddingReserveDAO;

    @Override
    public List<WeddingReserve> findList(WeddingReserve weddingReserve) {
        return weddingReserveDAO.findList(weddingReserve);
    }

    @Override
    public WeddingReserve get(Integer personalId, String date) {
        WeddingReserve weddingReserve = new WeddingReserve();
        weddingReserve.setPersonalId(personalId);
        weddingReserve.setReserveDate(date);
        List<WeddingReserve> list = this.findList(weddingReserve);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int save(WeddingReserve weddingReserve) {
        if(weddingReserve.getId() != null){
           return weddingReserveDAO.updateByPrimaryKeySelective(weddingReserve);
        }else {
           if(this.get(weddingReserve.getPersonalId(),weddingReserve.getReserveDate()) == null){
               return weddingReserveDAO.insert(weddingReserve);
           }else{
               return -1;
           }

        }
    }

    @Override
    public int delete(Integer id) {
        return weddingReserveDAO.deleteByPrimaryKey(id);
    }
}
