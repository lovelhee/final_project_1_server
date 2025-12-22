package com.ssafy.lasttable.auth.dto;

public class AuthResponse {
    private String accessToken;
    private String email;
    private String name;
    private String picture;

    public AuthResponse(String accessToken, String email, String name, String picture) {
        this.accessToken = accessToken;
        this.email = email;
        this.name = name;
        this.picture = picture;
    }

    public String getAccessToken() { return accessToken; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPicture() { return picture; }
}
