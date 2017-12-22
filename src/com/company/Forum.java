package com.company;

import com.company.options.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Forum {

    private static final Forum instance = new Forum();
    private static String name = "Forum";
    private SubForum mainForum;
    private List<User> userList;
    private List<User> adminList;
    private Scanner scanner = new Scanner(System.in);
    private List<SubForumOption> userSubForumOptions;
    private List<ThreadOption> userThreadOptions;
    private List<SubForumOption> adminSubForumOptions;
    private List<ThreadOption> adminThreadOptions;


    private Forum(){
        mainForum = new SubForum("Main");
        userList = new ArrayList<>();
        adminList = new ArrayList<>();
        userSubForumOptions = new ArrayList<>();
        addUserSubForumOptions();
        userThreadOptions = new ArrayList<>();
        addUserThreadOptions();
        adminSubForumOptions = new ArrayList<>();
        adminThreadOptions = new ArrayList<>();
    }


    public void setMainForum(SubForum mainForum) {
        this.mainForum = mainForum;
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

    public boolean checkUser(String nick, String password){
        for (User user : userList){
            if (user.getNick().equals(nick) && user.getPassword().equals(password)){
                return true;
            }
        }
        for (User user : adminList){
            if (user.getNick().equals(nick) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean checkAdmin(String nick, String password){
        for (User user : adminList){
            if (user.getNick().equals(nick) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUser(String nick, String password){
        for (User user : userList) {
            if (user.getNick().equals(nick) && user.getPassword().equals(password)) {
                return user;
            }
        }
        for (User user : adminList){
            if (user.getNick().equals(nick) && user.getPassword().equals(password)){
                return user;
                }
            }return null;
        }

    private void addUserThreadOptions(){
        this.userThreadOptions.add(new AddPost());
        this.userThreadOptions.add(new DeletePost());
        this.userThreadOptions.add(new GoBackToSubForum());
    }

    private void addUserSubForumOptions(){
        this.userSubForumOptions.add(new AddThread());
        this.userSubForumOptions.add(new GoToThread());
        this.userSubForumOptions.add(new GoToSubforum());
        this.userSubForumOptions.add(new GoBack());
    }





}

