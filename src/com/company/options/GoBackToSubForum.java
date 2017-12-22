package com.company.options;

import com.company.Thread;
import com.company.User;

public class GoBackToSubForum extends ThreadOption {

    public String optionName = "Go back";

    @Override
    public boolean start(Thread thread, User user) {
        //do nothing
        return true;
    }
}
