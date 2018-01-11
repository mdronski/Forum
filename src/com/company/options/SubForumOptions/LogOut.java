package com.company.options.SubForumOptions;

import com.company.UserInterface;
import com.company.WriterClass;

public class LogOut extends SubForumOption{

    public LogOut(){
        this.optionName = "Log out";
    }

    @Override
    public boolean start(UserInterface ui) {
        ui.setIfExit(true);
        WriterClass.writeAllForum();
        System.out.println();
        System.out.println();
        System.out.println();
      //  UserInterface UI = LoginClass.logIn();
      //  UI.showSubForumInterface();
        return true;
    }
}
