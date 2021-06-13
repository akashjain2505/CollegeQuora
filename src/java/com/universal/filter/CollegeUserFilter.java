package com.universal.filter;

import com.sun.net.httpserver.Filter;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "after",urlPatterns = {"/faculty/*","/student/*"})
public class CollegeUserFilter implements javax.servlet.Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {        
        System.out.println("Chala");
        HttpServletRequest req = (HttpServletRequest)request;
        String ctx = req.getContextPath();
        Object obj = req.getSession().getAttribute("loginuser");
        if(obj==null)
        {
            HttpServletResponse res = (HttpServletResponse)response;
            res.sendRedirect(ctx + "/web/login.jsp");            
        }
        else
        {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
