package com.charles.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chales.tang
 * @title TokenInterceptor
 * @discription 验证参数中是否传递Token信息
 * @date 2020/8/4 10:10 下午
 */
public class TokenInterceptor implements HandlerInterceptor {
    /**
     * @Discription 请求方法前置拦截 true:执行目标方法，反之亦然
     * @param request
     * @param response
     * @param handler
     * @Return boolean
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        System.out.println(">>>token<<<: " + token);
        if(StringUtils.isEmpty(token)){
            response.setStatus(500);
            response.getWriter().print("token is null");
            return false;
        }
        return true;
    }

    /**
     * @Discription <br>
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @Return void
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(">>>postHandle<<<");
    }

    /**
     * @Discription <br>
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @Return void
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(">>>afterCompletion<<<");
    }
}
