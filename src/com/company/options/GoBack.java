package com.company.options;

import com.company.UserInterface;

public class GoBack extends SubForumOption {

    public String optionName = "Go back";

    @Override
    public boolean start(UserInterface userInterface) {
        userInterface.setSubForum(userInterface.getPreviousSubForums().pop());
        return true;
    }
}
