package com.company;

import java.util.Scanner;

public class UserInterface {

    protected SubForum subForum ;
    protected SubForum previousSubForum;
    protected User user;
    protected Scanner scanner = new Scanner(System.in);

    public UserInterface(User user) {
        this.subForum = Forum.getInstance().getMainForum();
        this.previousSubForum = null;
        this.user = user;
        if (!Forum.getInstance().checkAdmin(user.getNick(), user.getPassword())) init();
    }

    public void init(){

    }




}
