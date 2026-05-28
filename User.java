package com.library.management;

public class User {

    private int userId;
    private String userName;

    // Constructor
    public User(int userId, String userName) {

        this.userId = userId;
        this.userName = userName;
    }

    // Getter Methods
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    // Display User Details
    @Override
    public String toString() {

        return "User ID : " + userId +
                "\nUser Name : " + userName;
    }
}