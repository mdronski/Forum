package com.company.options.SubForumOptions;

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
        if (userInterface.getPreviousSubForums().empty()) {
            return false;
        }
        else {
            userInterface.setSubForum(userInterface.getPreviousSubForums().pop());
            return true;
        }
    }
}
