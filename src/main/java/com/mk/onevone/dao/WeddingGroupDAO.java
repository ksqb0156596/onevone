package com.mk.onevone.dao;

import com.mk.onevone.entity.WeddingGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WeddingGroupDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WeddingGroup record);

    int insertSelective(WeddingGroup record);

    WeddingGroup selectByPrimaryKey(Integer id);

    List<WeddingGroup> findList(WeddingGroup weddingGroup);

    int updateByPrimaryKeySelective(WeddingGroup record);

    int updateByPrimaryKey(WeddingGroup record);
}