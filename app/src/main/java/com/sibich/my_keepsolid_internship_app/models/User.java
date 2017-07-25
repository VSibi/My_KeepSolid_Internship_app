package com.sibich.my_keepsolid_internship_app.models;

import java.util.Random;

public class User {

    public enum Category {
        FRIENDS,
        FAMILY,
        JOB,
        OTHER
    }

    private String mUserName;
    private int mUserId;
    private Category mCategory;
    private boolean isOnline;
    private String mUserAddress;

    public User(String mUserName, Category mCategory, int mUserId, boolean isOnline, String mUserAddress) {
        this.mUserName = mUserName;
        this.mCategory = mCategory;
        this.mUserId = mUserId;
        this.isOnline = isOnline;
        this.mUserAddress = mUserAddress;
    }

    public User(String mUserName, Category mCategory, boolean isOnline, String mUserAddress) {
        this.mUserName = mUserName;
        Random random = new Random();
        mUserId = random.nextInt();
        this.mCategory = mCategory;
        this.isOnline = isOnline;
        this.mUserAddress = mUserAddress;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category mCategory) {
        this.mCategory = mCategory;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUserAddress() {
        return mUserAddress;
    }

    public void setUserAddress(String mUserAddress) {
        this.mUserAddress = mUserAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return mUserId == user.mUserId;

    }

    @Override
    public int hashCode() {
        return mUserId;
    }

}
