package com.universal.controller;

import com.universal.dao.UserDao;
import com.universal.dto.User;
import com.universal.service.MailService;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "reg",urlPatterns = {"/saveuser"})
public class RegisterServlet extends HttpServlet
{   
    UserDao dao = new UserDao();
    private int getOTP() 
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);    
        return number;
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
            String ctx = getServletContext().getContextPath();
            String name = req.getParameter("uname");
            String email = req.getParameter("email");
            String pass = req.getParameter("pass");
            int type = Integer.parseInt(req.getParameter("type"));
            int branch = Integer.parseInt(req.getParameter("branch"));
            
            MailService ms = new MailService();
            int otp = getOTP();
            ms.sendVerifyMail(email,name,otp);
            
            User user = new User(name, email, pass, type, branch);           
            user.setOtp(otp);
            
            
            
            boolean status = dao.saveUser(user);
            System.out.println(status);
            
            if(status){
            resp.sendRedirect(ctx+"/web/verify.jsp");
            }
            else
            {
                resp.sendRedirect(ctx+"/web/register.jsp?res="+status);
            }
    }    
}
