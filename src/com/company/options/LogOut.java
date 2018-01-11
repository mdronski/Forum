package com.company.options;

import com.company.Forum;
import com.company.LoginClass;
import com.company.UserInterface;
import com.company.WriterClass;

public class LogOut extends SubForumOption{

    public LogOut(){
        this.optionName = "Log out";
    }

    @Override
    public boolean start(UserInterface ui) {
        WriterClass.writeAllForum();
        System.out.println();
        System.out.println();
        System.out.println();
        UserInterface UI = LoginClass.logIn();
        UI.showSubForumInterface();
        return true;
    }
}
