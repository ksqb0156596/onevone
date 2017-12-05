package com.mk.onevone.service.impl;

import com.mk.onevone.dao.UserDAO;
import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.User;
import com.mk.onevone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public ResultDTO getLogin(User user) {
        if((user = userDAO.getLogin(user)) != null){
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            request.getSession().setAttribute("username",user.getUsername());
            request.getSession().setAttribute("id",user.getId());
            return new ResultDTO(1,user);
        }
        return new ResultDTO(9,user);
    }
}
