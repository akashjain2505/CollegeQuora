package com.universal.dto;

public class User 
{    
    private int userId;
    private String name;
    private String mail;
    private String phone;
    private String password;
    private int type;
    private int branch;
    private int otp;
    private int isVerify;

    public User() {
    }
    public User(int userId, String name, String mail, String phone, String password, int type, int branch, int otp, int isVerify) {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.branch = branch;
        this.otp = otp;
        this.isVerify = isVerify;
    }
    
    public User(int userId, String name, String mail, String phone)
    {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.phone = phone;

    }
    
    
    public User(int userId, String name, String mail, String phone, int type, int branch, int isVerify) 
    {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.type = type;
        this.branch = branch;        
        this.isVerify = isVerify;
    }
    
    public User(int userId, String name, String mail, String phone,int branch) 
    {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.phone = phone;        
        this.branch = branch;                
    }

    public User(String name, String mail, String password, int type, int branch) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.type = type;
        this.branch = branch;
    }
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        if(phone==null){
            return "";
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(int isVerify) {
        this.isVerify = isVerify;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", mail=" + mail + ", phone=" + phone + ", password=" + password + ", type=" + type + ", branch=" + branch + ", otp=" + otp + ", isVerify=" + isVerify + '}';
    }
    
    
}
