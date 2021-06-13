package com.universal.dao;

import com.universal.dto.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao 
{
    public boolean saveAnswer(int uid,int qid,String ans)
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement savePS = cnn.prepareStatement("insert into "
                    + "answer(ans,qus,ans_by) "
                    + "value(?,?,?)");
            savePS.setString(1,ans);
            savePS.setInt(2,qid);
            savePS.setInt(3,uid);
            
            savePS.executeUpdate();
            cnn.close();
            return true;
            
        } catch (Exception ex) 
        {
            System.err.println("Save ANS Errro : "+ex.getMessage());
            return false;
        } 
    }
    
     public List<Answer> listAnswer(int qid)
    {
        List<Answer> answers = new ArrayList<>();
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select aid,ans,ans_date,name from answer,user "
                    + "where qus=? and answer.ans_by=user.uid order by aid DESC";
            PreparedStatement ps = cnn.prepareStatement(query);
            ps.setInt(1, qid);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int aid = rs.getInt("aid");
                String ans = rs.getString("ans");
                String date = rs.getString("ans_date");
                String faculty = rs.getString("name");
                
                Answer as = new Answer(aid, ans, date);
                as.setFacultyName(faculty);
                answers.add(as);
            }
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("get ans Err : "+ex.getMessage());
        }
        return answers;
    }
    
}
