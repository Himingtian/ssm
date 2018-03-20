package com.learnssm.ssm.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsmHandlerInterceptor implements HandlerInterceptor {
    /**
     * 执行controller方法之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求url
        String requestUrl = httpServletRequest.getRequestURL().toString();
        //放行登录相关请求
        if(requestUrl.contains("login")){
            return true;
        }
        //认证登录状态
        Object user = httpServletRequest.getSession().getAttribute("User");
        if(user != null){
            return true;
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/showlogin.action");
        return false;
    }

    /**
     * 执行controller方法时执行,还未返回视图
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * controller执行完毕时执行,视图已经返回,应用场景是业务完成后要清除资源与记录异常信息
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
