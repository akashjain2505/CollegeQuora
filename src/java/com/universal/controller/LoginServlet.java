package com.universal.controller;

import com.universal.dao.UserDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/loginuser"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ctx = getServletContext().getContextPath();
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        UserDao dao = new UserDao();
        User user = dao.checkUser(email, pass);

        if (user == null) {
            System.out.println("Failed");
        } else {
            int verify = user.getIsVerify();
            if (verify == 0) {
                resp.sendRedirect(ctx + "/web/verify.jsp");
            } else {
                // User Obj save into session
                HttpSession session = req.getSession();
                session.setAttribute("loginuser", user);
                
                Cookie c1 = new Cookie("cqmail", email);                
                Cookie c2 = new Cookie("cqpass", pass);
                resp.addCookie(c1);
                resp.addCookie(c2);

                if (user.getType() == 1) {
                    resp.sendRedirect(ctx + "/faculty/fachome.jsp");
                } else {
                    resp.sendRedirect(ctx + "/student/studhome.jsp");
                }
            }
        }
    }
}
