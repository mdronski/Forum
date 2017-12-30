package com.company;

import com.company.options.GoBackToSubForum;
import com.company.options.SubForumOption;
import com.company.options.ThreadOption;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UserInterface {

    protected SubForum subForum ;
    protected Stack<SubForum> previousSubForums;
    protected User user;
    protected Scanner scanner = new Scanner(System.in);
    private List<SubForumOption> subForumOptions2;
    private List<ThreadOption> threadOptions2;
    private String threadOptions = "1.Add new post,    2.Delete post,   3.Go back";
    private String subForumOptions = "1.Go to thread      2.Add new thread      3.Go back   4.Go to subForum";


    public UserInterface(User user, List<SubForumOption> subForumOptions, List<ThreadOption> threadOptions) {
        this.subForum = Forum.getInstance().getMainForum();
        this.previousSubForums = new Stack<>();
        this.user = user;
        this.subForumOptions2 = subForumOptions;
        this.threadOptions2 = threadOptions;
       // if (!Forum.getInstance().checkAdmin(user.getNick(), user.getPassword())) showSubForumInterface();
    }

    public SubForum getSubForum() {
        return subForum;
    }

    public Stack<SubForum> getPreviousSubForums() {
        return previousSubForums;
    }

    public User getUser() {
        return user;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public String getThreadOptions() {
        return threadOptions;
    }

    public String getSubForumOptions() {
        return subForumOptions;
    }

    public void setSubForum(SubForum subForum) {
        this.subForum = subForum;
    }

    public void setPreviousSubForums(Stack<SubForum> previousSubForums) {
        this.previousSubForums = previousSubForums;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setThreadOptions(String threadOptions) {
        this.threadOptions = threadOptions;
    }

    public void setSubForumOptions(String subForumOptions) {
        this.subForumOptions = subForumOptions;
    }

    public void showThreadInterface(int number){
        Thread thread = subForum.getThreads().get(number);
        System.out.println(thread);
        System.out.println();

        for(ThreadOption option : threadOptions2){
            System.out.print(threadOptions2.indexOf(option) + ". ");
            System.out.print(option.toString());
        }

        System.out.println();
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + optionNumber);
        threadOptions2.get(optionNumber).start(thread, user);
        if (!(threadOptions2.get(optionNumber) instanceof GoBackToSubForum)){
            showThreadInterface(number);
        }

    }

    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();

        for(SubForumOption option : subForumOptions2){
            System.out.print(subForumOptions2.indexOf(option) + ". ");
            System.out.print(option.toString());
        }


        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + number);
        System.out.println();
        subForumOptions2.get(number).start(this);
//        switch (number){
//            case 1:
//                showThreadInterface(getNumber("thread"));
//                break;
//
//            case 2:
//                addThread(getName("thread"));
//                break;
//
//            case 3:
//                subForum = previousSubForums.pop();
//                break;
//
//            case 4:
//                int subForumNumber = getNumber("subForum");
//                previousSubForums.push(subForum);
//                subForum = subForum.getSubForums().get(subForumNumber);
//                break;
//
//            default:
//                System.out.println("wrong argument");
//                break;
//
//        }
        showSubForumInterface();
    }

    public boolean addThread(String topic){
        Thread thread = new Thread(topic, this.user);
        if (!this.subForum.getThreads().contains(thread)) {
            this.subForum.getThreads().add(thread);
            System.out.println("Added new thread");
            return true;
        }
        return false;
    }

    public boolean addSubForum(String subject){
        SubForum subForum = new SubForum(subject);
        System.out.println("added new subForum");
        return this.subForum.addSubForum(subForum);
    }

    private int getNumber(String option){
        System.out.println("Choose " + option);
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("You choosed " + option + " " + number);
        return number;
    }

    private String getName(String option){
        System.out.println("Type " + option +  "name: ");
        return scanner.nextLine();
    }

    private String getContents(){
        System.out.println("Type contents of the post: ");
        return scanner.nextLine();
    }



}
