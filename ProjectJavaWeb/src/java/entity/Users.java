/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Users {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private String avatarUrl;
    private int role;

    public Users() {
    }

    public Users(int userId, String username, String password, String email, String name, String avatarUrl, int role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.role = role;
    }

    
    
    public Users(String username, String password, String email, String name, String avatarUrl, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.role = role;
    }
    
    public int getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    
    
    
}
