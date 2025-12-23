package com.ssafy.lasttable.user.dto;

public class LoginRequest {
    private String userId;
    private String pwd;

    // Getter & Setter
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }
}