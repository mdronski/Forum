package com.company;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private static final Forum instance = new Forum();
    private static String name = "Forum";
    private SubForum mainForum;
    private List<User> userList;
    private List<User> adminList;

    private Forum(){
        mainForum = new SubForum("Main");
        userList = new ArrayList<>();
        adminList = new ArrayList<>();
    }


    public static Forum getInstance() {
        return instance;
    }

    public static String getName() {
        return name;
    }

    public SubForum getMainForum() {
        return mainForum;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<User> getAdminList() {
        return adminList;
    }

    public boolean addNewUser(User user, boolean admin){
        if (!admin) {
            if (userList.contains(user)) {
                System.out.println("User already exists");
                return false;
            } else {
                return userList.add(user);
            }
        } else {
            if (adminList.contains(user)) {
                System.out.println("Admin already exists");
                return false;
            } else {
                return adminList.add(user);
            }
        }
    }
}
