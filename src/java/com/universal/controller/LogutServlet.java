package com.universal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout",urlPatterns = {"/logout"})
public class LogutServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
       req.getSession().invalidate();
        
        //req.getSession().removeAttribute(name);
        
        resp.sendRedirect(ctx+"/web/login.jsp");
    }
    
}
