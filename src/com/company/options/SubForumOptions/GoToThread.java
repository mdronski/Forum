package com.company.options.SubForumOptions;

import com.company.Forum;
import com.company.UserInterface;

import java.util.List;

public class GoToThread extends SubForumOption {

    public GoToThread() {
        optionName = "Go to thread";
    }



    @Override
    public boolean start(UserInterface ui) {
        int threadNumber = getNumber("thread", 0,ui.getSubForum().getThreads().size()-1);
        ui.handleThreadSession(threadNumber);
        return true;
    }
}
