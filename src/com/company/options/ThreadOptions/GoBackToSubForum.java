package com.company.options.ThreadOptions;

import com.company.Thread;
import com.company.User;

public class GoBackToSubForum extends ThreadOption {

    public GoBackToSubForum(){
        optionName = "Go back";
    }

    @Override
    public boolean start(Thread thread, User user) {
        //do nothing
        return true;
    }
}
