package com.company;

import java.util.ArrayList;
import java.util.List;

public class Thread {

    private String topic;
    private List<Post> posts;

    public Thread(String topic) {
        this.topic = topic;
        posts = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public boolean addPost(Post post){
        return posts.add(post);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(topic);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        for (Post post : posts){
            sb.append(post.toString());
            sb.append(System.getProperty("line.separator"));
        }
        return  sb.toString();
    }
}
