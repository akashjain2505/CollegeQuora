package com.universal.dao;

import com.universal.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao 
{   
    public boolean saveUser(User user)
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement saveUserPS = cnn.prepareStatement("insert into "
                    + "user(name,mail,password,type,branch,otp) "
                    + "value(?,?,?,?,?,?)");
            saveUserPS.setString(1,user.getName());
            saveUserPS.setString(2,user.getMail());
            saveUserPS.setString(3,user.getPassword());
            saveUserPS.setInt(4, user.getType());
            saveUserPS.setInt(5, user.getBranch());
            saveUserPS.setInt(6, user.getOtp());
            
            saveUserPS.executeUpdate();
            cnn.close();
            return true;
            
        } catch (Exception ex) 
        {
            System.err.println("Save User Errro : "+ex.getMessage());
            return false;
        }        
    }
    
    public User checkUser(String email,String pass)
    {
        User user = null;
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select * from user where mail=? and password=?";
            PreparedStatement loginPS = cnn.prepareStatement(query);
            loginPS.setString(1, email);
            loginPS.setString(2, pass);
            
            ResultSet rs = loginPS.executeQuery();
            
            if(rs.next())
            {
                int uid = rs.getInt("uid");
                String name = rs.getString("name");
                String mail = rs.getString("mail");
                String phone = rs.getString("phone");
                int type = rs.getInt("type");
                int branch = rs.getInt("branch");
                int isVerify = rs.getInt("isVerify");
                
                user = new User(uid, name, mail, phone, type, branch, isVerify);
            }
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("Login Err : "+ex.getMessage());
        }
        return user;
    }
    
    public List<User> listFaculty()
    {
        List<User> users = new ArrayList<>();
        try {
            Connection cnn = DbConnection.getConnection();
            
            String query = "select * from user where type=1";
            PreparedStatement ps = cnn.prepareStatement(query);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int uid = rs.getInt("uid");
                String name = rs.getString("name");
                String mail = rs.getString("mail");
                String phone = rs.getString("phone");                
                int branch = rs.getInt("branch");                
                
                User user = new User(uid, name, mail, phone, branch);
                users.add(user);
            }
            
            cnn.close();
            
        } catch (Exception ex) 
        {
            System.err.println("get faculty Err : "+ex.getMessage());
        }
        return users;
    }

    public boolean updateUser(User usr) 
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement saveUserPS = cnn.prepareStatement("update user set name=?,mail=?,phone=? where uid=?");
            saveUserPS.setString(1,usr.getName());
            saveUserPS.setString(2,usr.getMail());
            saveUserPS.setString(3,usr.getPhone());
            saveUserPS.setInt(4, usr.getUserId());
                        
            saveUserPS.executeUpdate();
            cnn.close();
            return true;
            
        } catch (Exception ex) 
        {
            System.err.println("Update User Errro : "+ex.getMessage());
            return false;
        }        
    }
    
    public boolean changePassword(int uid,String oldpass,String newpass)
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement ps = cnn.prepareStatement("update user set password=? where uid=? and password=?");
            ps.setString(1, newpass);
            ps.setInt(2, uid);
            ps.setString(3, oldpass);
            
            ps.executeUpdate();
            cnn.close();
            return true;
            
        } catch (Exception ex) 
        {
            System.err.println("Update password : "+ex.getMessage());
            return false;
        }  
    }

    public void verifyUser(String email, String otp) 
    {
        try 
        {
            Connection cnn = DbConnection.getConnection();
            PreparedStatement ps = cnn.prepareStatement("update user set isVerify=1 where mail=? and otp=?");
            ps.setString(1, email);
            ps.setInt(2, Integer.parseInt(otp));
            
            
            ps.executeUpdate();
            cnn.close();
            
            
        } catch (Exception ex) 
        {
            System.err.println("verify password : "+ex.getMessage());
            
        }
    }
}


