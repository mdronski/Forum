package com.company.options;

import com.company.User;
import com.company.Thread;

public class DeletePost extends ThreadOption {

    public DeletePost() {
        optionName = "Delete post";
    }


    @Override
    public boolean start(Thread thread, User user) {

        int number = getNumber("post");
        return thread.deletePost(thread.getPost(number), user);
    }
}
