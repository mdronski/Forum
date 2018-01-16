package com.company.options.SubForumOptions;

import com.company.UserInterface;

public class GoToSubforum extends SubForumOption {

    public GoToSubforum(){
        optionName = "Go to subForum";
    }


    @Override
    public boolean start(UserInterface ui) {
        int subforumNumber = getNumber("subForum",0, ui.getSubForum().getSubForums().size());
        ui.getPreviousSubForums().push(ui.getSubForum());
        ui.setSubForum(ui.getSubForum().getSubForums().get(subforumNumber));
        return true;
    }
}
