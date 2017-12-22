package com.company.options;

import com.company.UserInterface;

public class GoToThread extends SubForumOption {

    public String optionName = "Go to thread";

    @Override
    public boolean start(UserInterface ui) {
        ui.showThreadInterface(getNumber("thread"));
        return true;
    }
}
