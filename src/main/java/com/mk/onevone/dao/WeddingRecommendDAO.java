package com.mk.onevone.dao;

import com.mk.onevone.entity.WeddingGroup;
import com.mk.onevone.entity.WeddingPersonal;
import com.mk.onevone.entity.WeddingRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WeddingRecommendDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(WeddingRecommend record);

    int insertSelective(WeddingRecommend record);

    WeddingRecommend selectByPrimaryKey(Integer id);

    List<WeddingRecommend> findList(WeddingRecommend weddingRecommend);

    int updateByPrimaryKeySelective(WeddingRecommend record);

    int updateByPrimaryKey(WeddingRecommend record);

    List<WeddingPersonal> findRecommendByPerson();
    List<WeddingGroup> findRecommendByGroup();
}