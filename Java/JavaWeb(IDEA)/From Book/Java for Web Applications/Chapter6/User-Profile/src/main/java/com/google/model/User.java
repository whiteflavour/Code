package com.google.model;

import java.util.HashMap;
import java.util.Map;

/**
 * User POJO.
 *
 * @author Liao, wrox
 * @date 2021-3-16
 */
public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private final Map<String, Boolean> permissions = new HashMap<>();

    public User() {}
    public User(long id, String username, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Boolean> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return username + "; " + lastName + ", " + firstName;
    }
}
