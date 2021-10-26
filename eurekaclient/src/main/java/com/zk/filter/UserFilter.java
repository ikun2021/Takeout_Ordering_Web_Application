package com.zk.filter;

import com.zk.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/index.html","/mymenu/redirect/index","/order.html","/mymenu/redirect/order"} ,filterName ="userFilter")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse =(HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            httpServletResponse.sendRedirect("login.html");//没有视图解析器，直接写资源名称
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
