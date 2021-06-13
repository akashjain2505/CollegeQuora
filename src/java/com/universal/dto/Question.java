package com.universal.dto;

public class Question 
{
    private int qid;
    private String qus;
    private String date;
    private int student;
    private String studentName;

    public Question() {
    }

    public Question(int qid, String qus, String date, int student) {
        this.qid = qid;
        this.qus = qus;
        this.date = date;
        this.student = student;
    }
    
    public Question(int qid, String qus, String date) {
        this.qid = qid;
        this.qus = qus;
        this.date = date;        
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    
    
    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
    
    
}
