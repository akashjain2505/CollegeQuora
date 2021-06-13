package com.universal.dto;

public class Answer 
{
    private int ansId;
    private String ans;
    private String ansDate;
    private int qid;
    private int fid;
    private String facultyName;

    public Answer() {
    }

    public Answer(int ansId, String ans, String ansDate, int qid, int fid)
    {
        this.ansId = ansId;
        this.ans = ans;
        this.ansDate = ansDate;
        this.qid = qid;
        this.fid = fid;    
    }
    
    public Answer(int ansId, String ans, String ansDate)
    {
        this.ansId = ansId;
        this.ans = ans;
        this.ansDate = ansDate;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(String ansDate) {
        this.ansDate = ansDate;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    
    
    
    
}
