package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubForum implements Serializable {

    private String subject;
    private List<Thread> threads;
    private List<SubForum> subForums;
    protected static Scanner scanner = new Scanner(System.in);


    public SubForum(String subject) {
        this.subject = subject;
        this.threads = new ArrayList<>();
        this.subForums = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public List<SubForum> getSubForums() {
        return subForums;
    }

    public boolean addThread(Thread thread){
        return threads.add(thread);
    }

    public boolean addSubForum(SubForum subforum){
        return subForums.add(subforum);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(subject);
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("Threads: ");
        sb.append(System.getProperty("line.separator"));
        for (Thread thread : threads){
            sb.append(threads.indexOf(thread) + ". ");
            sb.append(thread.getTopic());
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(System.getProperty("line.separator"));
        sb.append("Sub-Forums:");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        for (SubForum subForum : subForums){
            sb.append(subForums.indexOf(subForum) + ". ");
            sb.append(subForum.getSubject());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }


}
