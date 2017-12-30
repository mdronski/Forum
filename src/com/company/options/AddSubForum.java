package com.company.options;

import com.company.SubForum;
import com.company.UserInterface;

public class AddSubForum extends SubForumOption {

    public AddSubForum(){this.optionName="Add new subForum";}


    @Override
    public boolean start(UserInterface ui) {
        String subject = getName("subForum");
        ui.addSubForum(subject);
        return false;
    }
}
