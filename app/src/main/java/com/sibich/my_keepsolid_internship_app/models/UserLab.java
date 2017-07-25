package com.sibich.my_keepsolid_internship_app.models;

import java.util.ArrayList;

/**
 * Created by Sibic_000 on 25.07.2017.
 */

public class UserLab {
    private static final UserLab ourInstance = new UserLab();


    private ArrayList<User> items;

    public static UserLab getInstance() {
        return ourInstance;
    }

    private UserLab() {

        items = new ArrayList<>();

        items.add(new User("Paul", User.Category.FRIENDS, true, "example@gmail.com"));
        items.add(new User("Robert", User.Category.FRIENDS, true, "rytt@ukr.net"));
        items.add(new User("Eva", User.Category.FAMILY, false, "guf@jh"));
        items.add(new User("Alex", User.Category.OTHER, false, "jhg@rffch"));
        items.add(new User("Slavik", User.Category.JOB, true, "fgf@kkkb"));
        items.add(new User("Barbara", User.Category.JOB, true, "fgf@kkkb"));
        items.add(new User("Fedot", User.Category.FRIENDS, false, "fgf@kkkb"));
        items.add(new User("Sanek", User.Category.FAMILY, true, "fgf@kkkb"));
        items.add(new User("Igor", User.Category.FRIENDS, false, "fgf@kkkb"));
        items.add(new User("Masha", User.Category.FRIENDS, false, "fgf@kkkb"));
        items.add(new User("Alena", User.Category.FRIENDS, false, "fgf@kkkb"));
        items.add(new User("Nataly", User.Category.FRIENDS, true, "fgf@kkkb"));
    }

    public ArrayList<User> getItems() {
        return items;
    }

    public void setItems(ArrayList<User> items) {
        this.items = items;
    }

    public User getUser(int id) {
        for (int i = 0; i < items.size(); i++) {
            User user = (User) items.get(i);
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }
}
