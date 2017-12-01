package com.oli.allmyfriends;

import java.io.Serializable;

/**
 * Created by oliver on 11/25/2017.
 */

public class UserDetails implements Serializable {

    public String name;
    public String lastname;
    public String username;
    public char gender;

    public UserDetails() {
    }

    public UserDetails(String name, String lastname, String username, char gender) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  username;

    }

    public static void add(UserDetails guest) {
    }
}
