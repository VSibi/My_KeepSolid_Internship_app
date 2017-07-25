package com.sibich.my_keepsolid_internship_app.models;

import java.util.Comparator;

public class SortEntriesAlphabetical implements Comparator<User> {

    public int compare(User obj1, User obj2) {

        String s1 = obj1.getUserName().toUpperCase();
        String s2 = obj2.getUserName().toUpperCase();

        return s1.compareTo(s2);
    }

}
