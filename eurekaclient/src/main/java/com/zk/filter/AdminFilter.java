package com.zk.filter;

import com.zk.entity.Admin;
import com.zk.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = {"/main.html","/mymenu/redirect/main"}, filterName = "adminFilter")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse =(HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin==null){
            httpServletResponse.sendRedirect("login.html");//没有视图解析器，直接写资源名称
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
