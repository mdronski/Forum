package com.company.options.AdminOptions;

import com.company.UserInterface;
import com.company.options.SubForumOptions.SubForumOption;

public class AddSubForum extends SubForumOption {

    public AddSubForum(){this.optionName="Add new subForum";}


    @Override
    public boolean start(UserInterface ui) {
        String subject = getName("subForum");
        ui.addSubForum(subject);
        return false;
    }
}
