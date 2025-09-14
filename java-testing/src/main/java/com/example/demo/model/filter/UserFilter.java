package com.example.demo.model.filter;


/**
 * Contoh object filter (dipakai saat membuat endpoint list user dengan filter).
 * Untuk sekarang ini hanya contoh, belum dipakai.
 */
public class UserFilter {
    private String usernameLike;
    private String fullNameLike;

    public String getUsernameLike() { return usernameLike; }
    public void setUsernameLike(String usernameLike) { this.usernameLike = usernameLike; }

    public String getFullNameLike() { return fullNameLike; }
    public void setFullNameLike(String fullNameLike) { this.fullNameLike = fullNameLike; }
}