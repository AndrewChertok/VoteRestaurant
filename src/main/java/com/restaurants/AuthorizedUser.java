package com.restaurants;


public class AuthorizedUser {

    private static int userId;

    public static void setUserId(int userId) {
        AuthorizedUser.userId = userId;
    }

    public static int id() {
        return userId;
    }
}
