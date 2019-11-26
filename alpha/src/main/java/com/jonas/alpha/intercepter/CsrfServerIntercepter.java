package com.jonas.alpha.intercepter;

import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CsrfServerIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("csrf_token-zte");
//        String method = request.getMethod();
//        if ((HttpMethod.POST.name().equals(method) ||
//                HttpMethod.PUT.name().equals(method) ||
//                HttpMethod.PATCH.name().equals(method))
//                && StringUtils.isEmpty(token)) {
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String id = UUID.randomUUID().toString();
//        ((ServerHttpResponse)response).getHeaders().add("csrf_token-zte",id);
        super.postHandle(request, response, handler, modelAndView);


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
