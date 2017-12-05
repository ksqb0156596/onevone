package com.mk.onevone.service;

import com.mk.onevone.entity.WeddingReserve;

import java.util.List;

public interface WeddingReserveService {
    List<WeddingReserve> findList(WeddingReserve weddingReserve);
    WeddingReserve get(Integer personalId,String date);
    int save(WeddingReserve weddingReserve);
    int delete(Integer id);
}
