package com.company;

import java.util.Scanner;
import java.util.Stack;

public class UserInterface {

    protected SubForum subForum ;
    protected Stack<SubForum> previousSubForums;
    protected User user;
    protected Scanner scanner = new Scanner(System.in);
    private String threadOptions = "1.Add new post,    2.Delete post,   3.Go back";
    private String subForumOptions = "1.Go to thread    2.Add new subForum    3.Add new thread      4.Go back   5.Go to subForum";


    public UserInterface(User user) {
        this.subForum = Forum.getInstance().getMainForum();
        this.previousSubForums = new Stack<>();
        this.user = user;
       // if (!Forum.getInstance().checkAdmin(user.getNick(), user.getPassword())) showSubForumInterface();
    }



    public void showThreadInterface(int number){
        System.out.println(subForum.getThreads().get(number));
        System.out.println();
        System.out.println(threadOptions);
        System.out.println();
        int optionNumber = scanner.nextInt();
        System.out.println("you chosed option number: " + optionNumber);
        if (number == 1 || number == 2 ) showThreadInterface(number);
    }


    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();
        System.out.println(subForumOptions);
        int number = scanner.nextInt();
        System.out.println("you chosed option number: " + number);
        System.out.println();
        switch (number){
            case 1:
                System.out.println("Chose thread: ");
                int threadNumber = scanner.nextInt();
                System.out.println("you chosed Thread: " + threadNumber);
                showThreadInterface(threadNumber);
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                subForum = previousSubForums.pop();
                showSubForumInterface();
                break;

            case 5:
                System.out.println("Chose subForum: ");
                int subForumNumber = scanner.nextInt();
                System.out.println("you chosed subforum: " + subForumNumber);
                previousSubForums.push(subForum);
                subForum = subForum.getSubForums().get(subForumNumber);
                showSubForumInterface();
                break;

            default:
                System.out.println("wrong argument");
                break;

        }

    }









}
