package com.mk.onevone.service;

import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    ResultDTO getLogin(User user);
    ResultDTO getCodeLogin(String phone, String code);
    ResultDTO getMessageCode(String phone);
}
