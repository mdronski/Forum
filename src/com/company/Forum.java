package com.company;

import com.company.options.AdminOptions.*;
import com.company.options.SubForumOptions.*;
import com.company.options.ThreadOptions.AddPost;
import com.company.options.ThreadOptions.DeletePost;
import com.company.options.ThreadOptions.GoBackToSubForum;
import com.company.options.ThreadOptions.ThreadOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Forum implements Serializable {

    private static final Forum instance = new Forum();
    private static String name = "Forum";
    private SubForum mainForum;
    private List<User> userList;
    private List<User> adminList;
    private static Scanner scanner = new Scanner(System.in);
    private List<SubForumOption> userSubForumOptions;
    private List<ThreadOption> userThreadOptions;
    private List<SubForumOption> adminSubForumOptions;
    private List<ThreadOption> adminThreadOptions;
    private List<AdminOption> adminOptions;

    private Forum(){
        mainForum = (SubForum) ReaderClass.read("MainForum.ser") ;
        userList = (List<User>) ReaderClass.read("UserList.ser");
        adminList =(List<User>) ReaderClass.read("AdminList.ser");
//        userList = new ArrayList<>();
//        adminList = new ArrayList<>();
        userSubForumOptions = new ArrayList<>();
        addSubForumOptions();
        userThreadOptions = new ArrayList<>();
        addThreadOptions();
        adminSubForumOptions = new ArrayList<>();
        addAdminSubForumOptions();
        adminThreadOptions = new ArrayList<>();
        addAdminThreadOptions();
        adminOptions = new ArrayList<>();
        addAdminOptions();
//        adminList.add(new User("mdronski","haslo"));
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

    public List<SubForumOption> getUserSubForumOptions() {
        return userSubForumOptions;
    }

    public List<ThreadOption> getUserThreadOptions() {
        return userThreadOptions;
    }

    public List<SubForumOption> getAdminSubForumOptions() {
        return adminSubForumOptions;
    }

    public List<ThreadOption> getAdminThreadOptions() {
        return adminThreadOptions;
    }

    public List<AdminOption> getAdminOptions() {
        return adminOptions;
    }

    public boolean addNewUser(User user){
            if (userList.contains(user) || adminList.contains(user)) {
                System.out.println("User already exists");
                return false;
            } else {
                return userList.add(user);
            }
    }

    public boolean checkUser(User user){
        return (this.userList.contains(user) || this.adminList.contains(user));
    }

    public boolean checkAdmin(User user){
        return (this.userList.contains(user) || this.adminList.contains(user));
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

    public User getUser(String nick){
        for (User user : userList) {
            if (user.getNick().equals(nick)) {
                return user;
            }
        }
        for (User user : adminList){
            if (user.getNick().equals(nick)){
                return user;
            }
        }return null;
    }

    private void addThreadOptions(){
        this.userThreadOptions.add(new AddPost());
        this.userThreadOptions.add(new DeletePost());
        this.userThreadOptions.add(new GoBackToSubForum());
    }

    private void addSubForumOptions(){
        this.userSubForumOptions.add(new GoBack());
        this.userSubForumOptions.add(new AddThread());
        this.userSubForumOptions.add(new GoToThread());
        this.userSubForumOptions.add(new GoToSubforum());
        this.userSubForumOptions.add(new LogOut());
    }

    private void addAdminThreadOptions(){
        this.adminThreadOptions.addAll(userThreadOptions);

    }

    private void addAdminSubForumOptions(){
        this.adminSubForumOptions.addAll(userSubForumOptions);
//        for (SubForumOption option : this.adminSubForumOptions){
//            if (option instanceof LogOut){
//                this.adminSubForumOptions.remove(option);
//            }
//        }
        this.adminSubForumOptions.add(this.adminSubForumOptions.size()-1 ,new AddSubForum());
//        this.adminSubForumOptions.add(new LogOut());
    }

    private void addAdminOptions(){
        this.adminOptions.add(new PromoteToAdmin());
        this.adminOptions.add(new ShowUsers());
        this.adminOptions.add(new BannUser());
        this.adminOptions.add(new GoBackFromAdmin());
    }

    public static int getOptionNumber(int minValue, int maxValue){
        String num = scanner.nextLine();

        while (!isInteger(num) || Integer.parseInt(num) < minValue || Integer.parseInt(num) > maxValue){
            if (!isInteger(num)){
                System.out.println("You have to enter an integer!");
            }else {
                System.out.println("You have to chose number from " + minValue + " to " + maxValue);
            }
            num = scanner.nextLine();
        }

        return Integer.parseInt(num);


    }

    private static boolean isInteger(String str)
    {
        try
        {
            int i = Integer.parseInt(str);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }


}

