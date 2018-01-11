package com.company;

import com.company.options.GoBack;
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
    protected List<SubForumOption> subForumOptions;
    protected List<ThreadOption> threadOptions;

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

    public void showThreadInterface(int number){
        Thread thread = subForum.getThreads().get(number);
        System.out.println(thread);
        System.out.println();

        for(ThreadOption option : threadOptions){

            System.out.print(threadOptions.indexOf(option) + ". ");      /////////// poprawa odrekurencynić!!!!!!
            System.out.print(option.toString());
        }

        System.out.println();
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + optionNumber);
        threadOptions.get(optionNumber).start(thread, user);
        if (!(threadOptions.get(optionNumber) instanceof GoBackToSubForum)){
            cleanConsole();
            showThreadInterface(number);
        }

    }

    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();

        for(SubForumOption option : subForumOptions){
//            if (previousSubForums.empty() && option instanceof GoBack) {
//                continue;
//            }
            System.out.print(subForumOptions.indexOf(option) + ". ");
            System.out.print(option.toString());
        }


        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + number);
        System.out.println();
        subForumOptions.get(number).start(this);

        cleanConsole();
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
