package com.mk.onevone.service;

import com.mk.onevone.entity.WeddingGroup;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 01436296 on 2017/10/12.
 */
public interface WeddingGroupService {
    int save(WeddingGroup weddingGroup);
    int delete(int id,int status);
    List<WeddingGroup> findList(WeddingGroup weddingGroup);
    WeddingGroup get(int id);
}
