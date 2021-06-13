package com.universal.controller;

import com.universal.dao.AnswerDao;
import com.universal.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="saveans",urlPatterns = {"/saveAnswer"})
public class SaveAnswerServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String ctx = getServletContext().getContextPath();
        User user = (User)req.getSession().getAttribute("loginuser");
        
        int qid = Integer.parseInt(req.getParameter("qid"));
        String ans = req.getParameter("ans");
        
        AnswerDao adao = new AnswerDao();
        adao.saveAnswer(user.getUserId(), qid, ans);
        resp.sendRedirect(ctx+"/faculty/fachome.jsp");
    }    
}
