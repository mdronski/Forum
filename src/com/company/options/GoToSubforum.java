package com.company.options;

import com.company.UserInterface;

public class GoToSubforum extends SubForumOption {

    public GoToSubforum(){
        optionName = "Go to subForum";
    }


    @Override
    public boolean start(UserInterface ui) {
        int number = getNumber("subForum");
        ui.getPreviousSubForums().push(ui.getSubForum());
        ui.setSubForum(ui.getSubForum().getSubForums().get(number));
        return true;
    }
}
