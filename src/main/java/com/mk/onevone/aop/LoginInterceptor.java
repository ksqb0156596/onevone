package com.mk.onevone.aop;

import com.alibaba.fastjson.JSON;
import com.mk.onevone.dto.ResultDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    public static final String AJAX_ACCEPT_HEARDER = "X-Requested-With";
    public static final String AJAX_REQUEST = "XMLHttpRequest";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if(request.getSession().getAttribute("id") != null){
            return true;
        }else{
            String path = request.getRequestURI();
            if("wechat-onevone".equals(request.getParameter("key"))){

                if(path.contains("/get") || path.contains("/find") || path.contains("/reserve")){
                    return true;
                }
            }else if(path.contains("/login")){
                return true;
            }
            String acceptHeader = request.getHeader("Accept");
            String ajaxParam = request.getHeader(AJAX_ACCEPT_HEARDER);
            if(AJAX_REQUEST.equals(ajaxParam)){
                response.getWriter().print(JSON.toJSONString(new ResultDTO<>(9)));
            }else{
                response.sendRedirect("/login");
            }

            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
