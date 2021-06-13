package com.universal.controller;

import com.universal.dao.UserDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "verify", urlPatterns = {"/verify"})
public class VerifyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
        String email = req.getParameter("email");
        String otp = req.getParameter("otp");

        UserDao dao = new UserDao();
        dao.verifyUser(email, otp);
        resp.sendRedirect(ctx+"/web/login.jsp");
    }
}
