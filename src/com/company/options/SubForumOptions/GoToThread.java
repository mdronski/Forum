package com.company.options.SubForumOptions;

import com.company.UserInterface;

public class GoToThread extends SubForumOption {

    public GoToThread() {
        optionName = "Go to thread";
    }



    @Override
    public boolean start(UserInterface ui) {
        ui.handleThreadSession(getNumber("thread"));
        return true;
    }
}
