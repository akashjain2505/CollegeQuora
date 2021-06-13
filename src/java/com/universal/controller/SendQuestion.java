package com.universal.controller;

import com.universal.dao.QuestionDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "savequs",urlPatterns = {"/sendquestion"})
public class SendQuestion extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
        User user = (User)req.getSession().getAttribute("loginuser");
        String qus = req.getParameter("qus");
        QuestionDao dao = new QuestionDao();
        dao.saveQuestion(user.getUserId(), qus);
        resp.sendRedirect(ctx+"/student/studquestions.jsp");
    }    
}
