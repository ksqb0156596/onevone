package com.mk.onevone.dao;

import com.mk.onevone.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User getLogin(User user);
}
