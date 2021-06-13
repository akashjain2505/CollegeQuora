package com.universal.dao;

import com.universal.dto.Question;
import com.universal.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionDao 
{
    public boolean saveQuestion(int uid,String qus)
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement savePS = cnn.prepareStatement("insert into "
                    + "question(qus,ask_by) "
                    + "value(?,?)");
            savePS.setString(1,qus);
            savePS.setInt(2,uid);
            
            savePS.executeUpdate();
            cnn.close();
            return true;
            
        } catch (Exception ex) 
        {
            System.err.println("Save Qus Errro : "+ex.getMessage());
            return false;
        } 
    }
    
    public List<Question> listQuestion(int uid)
    {
        List<Question> questions = new ArrayList<>();
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select * from question where ask_by="+uid+" order by qid DESC";
            PreparedStatement ps = cnn.prepareStatement(query);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                String date = rs.getString("qus_date");
                int student = rs.getInt("ask_by");
                
                Question q = new Question(qid, qus, date, student);
                questions.add(q);
            }
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("get qus Err : "+ex.getMessage());
        }
        return questions;
    }
    
    public String getQuestionName(int qid)
    {
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select qus from question where qid="+qid;                    
            PreparedStatement ps = cnn.prepareStatement(query);
                        
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {                
                String qus = rs.getString("qus");
                return qus;
            }
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("get qus by id Err : "+ex.getMessage());
        }
        return "Question Not Found !";
    }
    
    public List<Question> listQuestionByBranch(int branch)
    {
        List<Question> questions = new ArrayList<>();
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select qid,qus,qus_date,name from "
                    + "question,user where ask_by in "
                    + "(select uid from user where branch=? and type=2) "
                    + "and question.ask_by=user.uid "
                    + "order by qid DESC";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setInt(1, branch);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int qid = rs.getInt("qid");
                String qus = rs.getString("qus");
                String date = rs.getString("qus_date");
                String student = rs.getString("name");
                
                Question q = new Question(qid, qus, date);
                q.setStudentName(student);
                questions.add(q);
            }
            
            String str = UUID.randomUUID().toString();
            System.out.println(str);
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("get qus Err : "+ex.getMessage());
        }
        return questions;
    }
}
