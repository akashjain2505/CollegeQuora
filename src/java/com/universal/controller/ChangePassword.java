package com.universal.controller;

import com.universal.dao.UserDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "chnage",urlPatterns = {"/changepass"})
public class ChangePassword extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
        User user = (User)req.getSession().getAttribute("loginuser");
        String oldpass = req.getParameter("oldpass");
        String newpass = req.getParameter("newpass");
        
        UserDao dao = new UserDao();
        dao.changePassword(user.getUserId(), oldpass, newpass);
        resp.sendRedirect(ctx+"/logout");
    }       
}
