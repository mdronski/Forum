package com.company.options;

import com.company.User;
import com.company.Thread;

public class DeletePost extends ThreadOption {

    public String optionName = "Delete post";

    @Override
    public boolean start(Thread thread, User user) {

        int number = getNumber("thread");
        return thread.deletePost(thread.getPost(number));
    }
}
