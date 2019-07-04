package com.example.test.Model;

public class UserData {

    private int id;
    private String user_name;
    private String user_age;
    private String user_voiceinput;

    public UserData(int id, String user_name, String user_age, String user_voiceinput) {
        this.id = id;
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_voiceinput = user_voiceinput;
    }

    public UserData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_voiceinput() {
        return user_voiceinput;
    }

    public void setUser_voiceinput(String user_voiceinput) {
        this.user_voiceinput = user_voiceinput;
    }
}
