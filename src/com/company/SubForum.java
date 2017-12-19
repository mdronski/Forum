package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubForum {

    private String subject;
    private List<Thread> threads;
    private List<SubForum> subForums;
    protected Scanner scanner = new Scanner(System.in);
//    private String options = "1.Go to thread    2.Add new subForum    3.Add new thread      4.Go back";

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

//    public void showSubForumInterface(){
//        System.out.println(this);
//        System.out.println();
//        System.out.println(options);
//        int number = scanner.nextInt();
//        System.out.println("you chosed option number: " + number);
//        switch (number){
//            case 1:
//                System.out.println("Chose thread: ");
//                int threadNumber = scanner.nextInt();
//                System.out.println("you chosed Thread: " + threadNumber);
//                threads.get(threadNumber).showThreadInterface();
//                break;
//
//            case 2:
//                break;
//
//            case 3:
//                break;
//
//            case 4:
//
//                break;
//
//            default:
//                System.out.println("wrong argument");
//                break;
//
//        }
//
//    }





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
