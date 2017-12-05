package com.mk.onevone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mk.onevone.dao.WeddingGroupDAO;
import com.mk.onevone.entity.WeddingGroup;
import com.mk.onevone.service.WeddingGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author 01436296
 * @date 2017/10/12
 */
@Service
public class WeddingGroupServiceImpl implements WeddingGroupService {

    @Autowired
    private WeddingGroupDAO weddingGroupDAO;

    @Override
    public int save(WeddingGroup weddingGroup) {
        if(weddingGroup.getId() == null) {
            return weddingGroupDAO.insert(weddingGroup);
        }
        return weddingGroupDAO.updateByPrimaryKeySelective(weddingGroup);
    }

    @Override
    public int delete(int id, int status) {
        return weddingGroupDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<WeddingGroup> findList(WeddingGroup weddingGroup) {
        return weddingGroupDAO.findList(weddingGroup);
    }

    @Override
    public PageInfo<WeddingGroup> findList(WeddingGroup weddingGroup, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(this.findList(weddingGroup));
    }

    @Override
    public WeddingGroup get(int id) {
        return weddingGroupDAO.selectByPrimaryKey(id);
    }
}
