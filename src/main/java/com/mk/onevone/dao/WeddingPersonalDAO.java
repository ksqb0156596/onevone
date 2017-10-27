package com.mk.onevone.dao;

import com.mk.onevone.entity.WeddingGroup;
import com.mk.onevone.entity.WeddingPersonal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WeddingPersonalDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WeddingPersonal record);

    int insertSelective(WeddingPersonal record);

    WeddingPersonal selectByPrimaryKey(Integer id);

    List<WeddingPersonal> findList(WeddingPersonal weddingPersonal);
    List<WeddingPersonal> findListByRecommend();

    int updateByPrimaryKeySelective(WeddingPersonal record);

    int updateByPrimaryKey(WeddingPersonal record);
}