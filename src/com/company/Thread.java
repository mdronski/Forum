package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thread {

    private String topic;
    private List<Post> posts;
    private User user;
    protected Scanner scanner = new Scanner(System.in);



    public Thread(String topic, User user) {
        this.topic = topic;
        this.user = user;
        posts = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public boolean addPost(Post post){
        return posts.add(post);
    }

    public boolean deletePost(Post post){
        return posts.remove(post);
    }

    public User getUser() {
        return user;
    }

    public Post getPost(int number){
        return posts.get(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(topic);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        for (Post post : posts){
            sb.append(posts.indexOf(post) + ". ");
            sb.append(post.toString());
            sb.append(System.getProperty("line.separator"));
        }
        return  sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }


        if (! (o instanceof  Thread)){
            return false;
        }

        Thread thread = (Thread) o;
        return this.topic.equals(thread.getTopic()) ;

    }
}
