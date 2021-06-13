package com.universal.controller;

import com.universal.dao.UserDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "update",urlPatterns = {"/updateuser"})
public class UpdateServlet extends HttpServlet
{   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
            User user = (User)req.getSession().getAttribute("loginuser");
            
            int userid = user.getUserId();
            String name = req.getParameter("uname");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            
            User usr = new User(userid, name, email, phone);
            
            UserDao dao = new UserDao();
            boolean status = dao.updateUser(usr);
            
            if(status)
            {
                user.setName(name);
                user.setMail(email);
                user.setPhone(phone);
            }
            
            resp.sendRedirect(ctx+"/faculty/fachome.jsp");
    }    
}
