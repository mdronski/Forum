package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thread {

    private String topic;
    private List<Post> posts;
//    private String threadOptions = "1.Add new post,    2.Delete post,   3.Go back";
    protected Scanner scanner = new Scanner(System.in);



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

//    public void showThreadInterface(){
//        System.out.println(this);
//        System.out.println();
//        System.out.println(threadOptions);
//        System.out.println();
//        int number = scanner.nextInt();
//        System.out.println("you chosed option number: " + number);
//        if (number == 1 || number == 2 ) showThreadInterface();
//    }



}
