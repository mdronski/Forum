package com.company.options;

import com.company.UserInterface;

public class GoBack extends SubForumOption {

    public GoBack(){
        optionName = "Go back";
    }

    public String getOptionName() {
        return optionName;
    }


    @Override
    public boolean start(UserInterface userInterface) {
        userInterface.setSubForum(userInterface.getPreviousSubForums().pop());
        return true;
    }
}
