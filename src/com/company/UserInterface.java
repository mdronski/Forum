package com.company;

import com.company.options.ThreadOptions.GoBackToSubForum;
import com.company.options.SubForumOptions.SubForumOption;
import com.company.options.ThreadOptions.ThreadOption;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UserInterface {

    protected SubForum subForum ;
    protected Stack<SubForum> previousSubForums;
    protected User user;
    protected Scanner scanner = new Scanner(System.in);
    protected List<SubForumOption> subForumOptions;
    protected List<ThreadOption> threadOptions;
    protected boolean forumExit = false;
    protected boolean threadExit = false;

    public UserInterface(User user, List<SubForumOption> subForumOptions, List<ThreadOption> threadOptions) {
        this.subForum = Forum.getInstance().getMainForum();
        this.previousSubForums = new Stack<>();
        this.user = user;
        this.subForumOptions = subForumOptions;
        this.threadOptions = threadOptions;
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

    public boolean isForumExit() {
        return forumExit;
    }

    public void setForumExit(boolean forumExit) {
        this.forumExit = forumExit;
    }

    public void setSubForum(SubForum subForum) {
        this.subForum = subForum;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void handleThreadSession(int threadNumber){
        while (!threadExit){
            showThreadInterface(threadNumber);
        }
        threadExit = false;
    }

    public void showThreadInterface(int threadNumber){
        Thread thread = subForum.getThreads().get(threadNumber);
        System.out.println(thread);
        System.out.println();

        for(ThreadOption option : threadOptions){

            System.out.print(threadOptions.indexOf(option) + ". ");
            System.out.print(option.toString());
        }

        System.out.println();

        int optionNumber = Forum.getOptionNumber(0, threadOptions.size()-1);

        threadOptions.get(optionNumber).start(thread, user);
        if (threadOptions.get(optionNumber) instanceof GoBackToSubForum){
            this.threadExit = true;
        }
        System.out.println();
        cleanConsole();

    }

    public void handleForumSession(){
        while (!forumExit){
            showSubForumInterface();
        }

    }

    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();

        for(SubForumOption option : subForumOptions)
        {
            System.out.print(subForumOptions.indexOf(option) + ". ");
            System.out.print(option.toString());
        }

        int number = Forum.getOptionNumber(0, subForumOptions.size()-1);
        System.out.println();
        subForumOptions.get(number).start(this);

        System.out.println();
        cleanConsole();
    }

    public boolean addSubForum(String subject){
        for (SubForum subForum : this.subForum.getSubForums()){
            if (subject.equals(subForum.getSubject())){
                System.out.println("On this level already exists subForum with the same subject!");
                return false;
            }
        }
        SubForum subForum = new SubForum(subject);
        System.out.println("added new subForum");
        return this.subForum.addSubForum(subForum);
    }

    protected void cleanConsole(){
                    try
            {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows"))
                {
                    Runtime.getRuntime().exec("cls");
                }
                else
                {
                    Runtime.getRuntime().exec("clear");
                }
            }
            catch (final Exception e)
            {
                System.out.println("Error with checking OS type");
            }
        }



}
