package com.mk.onevone.service.impl;

import com.mk.onevone.dao.UserDAO;
import com.mk.onevone.dto.ResultDTO;
import com.mk.onevone.entity.User;
import com.mk.onevone.service.UserService;
import com.mk.onevone.util.CacheUtil;
import com.mk.onevone.util.Commons;
import com.mk.onevone.util.SendMessage;
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

    @Override
    public ResultDTO getCodeLogin(String phone, String code) {
        if(code.equals(String.valueOf(CacheUtil.get(phone)))){
            return new ResultDTO(1);
        }
        return new ResultDTO(1);
    }

    @Override
    public ResultDTO getMessageCode(String phone) {
        String ip = Commons.getIpAddress();
        if(CacheUtil.get(CacheUtil.USER_CACHE, ip) != null || CacheUtil.get(CacheUtil.USER_CACHE, phone) != null){
            return new ResultDTO(-1,"一分钟内只能发送一次");
        }
        CacheUtil.put(CacheUtil.USER_CACHE, ip, "");
        CacheUtil.put(CacheUtil.USER_CACHE, phone, "");
        String code = (String) CacheUtil.get(phone);
        //10分钟内发送同一个验证码
        if(code == null){
            code = Commons.genVerificationCode();
            CacheUtil.put(phone, code);
        }
        return new ResultDTO(SendMessage.send(phone,code));
    }
}
