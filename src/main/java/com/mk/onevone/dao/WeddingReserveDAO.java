package com.mk.onevone.dao;

import com.mk.onevone.entity.WeddingReserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeddingReserveDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WeddingReserve record);

    int insertSelective(WeddingReserve record);

    WeddingReserve selectByPrimaryKey(Integer id);
    List<WeddingReserve> findList(WeddingReserve record);

    int updateByPrimaryKeySelective(WeddingReserve record);

    int updateByPrimaryKey(WeddingReserve record);
}