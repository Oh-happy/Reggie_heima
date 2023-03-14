package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;

/**
 * @author 10422
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j

public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI =request.getRequestURI();
        log.info("拦截到请求：{}",requestURI);

        String[] urls =new String[]{
                "/employee/login",
                "/employee/logout",
                "/employee/page",
                "/backend/**",
                "/front/**"
        };

        boolean check1=check(urls,requestURI);
        if (check1){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        if(request.getSession().getAttribute("employee") !=null){
            Long empId=(Long) request.getSession().getAttribute("employee");
            long id =Thread.currentThread().getId();
            log.info("线程id为{}",id);
            BaseContext.setCurrentId(empId);


            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }


    public Boolean check(String[] urls , String requestURI){
        for (String url:urls) {
            boolean match =PATH_MATCHER.match(url,requestURI);
            if (match){
                return true;
            }
        }
        return false;
    }
}
