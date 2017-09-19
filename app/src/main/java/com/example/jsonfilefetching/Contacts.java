package com.example.jsonfilefetching;

/**
 * Created by jisajose on 2017-09-13.
 */

public class Contacts {
    private  String name,email_id,created_at,updated_at,token,user_id,id;

    public Contacts(String id,String name, String email_id, String created_at, String updated_at, String token, String user_id) {
        this.setId(id);
        this.setName(name);
        this.setEmail_id(email_id);
        this.setCreated_at(created_at);
        this.setUpdated_at(updated_at);
        this.setToken(token);
        this.setUser_id(user_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
};

