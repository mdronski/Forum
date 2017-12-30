package com.company.options;

import com.company.Thread;
import com.company.UserInterface;

public class AddThread extends SubForumOption {

    public AddThread() {
        optionName = "Add Thread";
    }

    @Override
    public boolean start(UserInterface ui) {
        String topic = this.getName("thread");
        Thread thread = new Thread(topic, ui.getUser());
        if (!ui.getSubForum().getThreads().contains(thread)) {
            ui.getSubForum().getThreads().add(thread);
            System.out.println("Added new thread");
            return true;
        }
        return false;
    }



}
