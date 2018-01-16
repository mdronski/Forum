package com.company.options.ThreadOptions;

import com.company.User;
import com.company.Thread;

public class DeletePost extends ThreadOption {

    public DeletePost() {
        optionName = "Delete post";
    }


    @Override
    public boolean start(Thread thread, User user) {

        int postNumber = getNumber("post",0 , thread.getPosts().size());
        return thread.deletePost(thread.getPost(postNumber), user);
    }
}
