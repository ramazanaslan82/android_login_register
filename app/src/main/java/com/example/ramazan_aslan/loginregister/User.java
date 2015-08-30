package com.example.ramazan_aslan.loginregister;

/**
 * Created by ramazan_aslan on 30/08/15.
 */
public class User {
    private String name;
    private int age;
    private String username;
    private String password;

    public User(String nameSurname, int age, String username, String password) {
        this.name = nameSurname;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
