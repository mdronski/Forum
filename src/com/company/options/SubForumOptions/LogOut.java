package com.company.options.SubForumOptions;

import com.company.UserInterface;
import com.company.WriterClass;

public class LogOut extends SubForumOption{

    public LogOut(){
        this.optionName = "Log out";
    }

    @Override
    public boolean start(UserInterface ui) {
        ui.setForumExit(true);
        WriterClass.writeAllForum();
        System.out.println("Logged out");
        System.out.println();
        System.out.println();
        return true;
    }
}
