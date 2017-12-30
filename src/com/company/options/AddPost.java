package com.company.options;

import com.company.Post;
import com.company.Thread;
import com.company.User;

public class AddPost extends ThreadOption {

    public AddPost() {
        optionName = "Add new post";
    }


    @Override
    public boolean start(Thread thread, User user) {
        System.out.println("Type contents of the post: ");
        String contents =  scanner.nextLine();
        return thread.addPost(new Post(contents, user));
    }
}
