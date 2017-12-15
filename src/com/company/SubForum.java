package com.company;

import java.util.List;

public class SubForum {

    private String subject;
    private List<Thread> threads;
    private List<SubForum> subForums;


    public String getSubject() {
        return subject;
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
