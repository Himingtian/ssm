package com.learnssm.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class SsmHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SsmException ssmException = null;
        if (e instanceof SsmException){
             ssmException = (SsmException) e;
        }else {
            ssmException = new SsmException("网络异常请检查您的网络...");
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            stringWriter.toString();
        }
        ModelAndView view = new ModelAndView();
        view.addObject("message",ssmException.getMessage());
        view.setViewName("error");


        return view;
    }
}
