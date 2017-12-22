package com.company.options;

import com.company.User;
import com.company.Thread;
import java.util.Scanner;


public abstract class ThreadOption {

    public String optionName;
    protected Scanner scanner = new Scanner(System.in);


    public abstract boolean start(Thread thread, User user);

    protected int getNumber(String option){
        System.out.println("Choose " + option);
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("You choosed " + option + " " + number);
        return number;
    }

    protected String getName(String option){
        System.out.println("Type " + option +  "name: ");
        return scanner.nextLine();
    }

    protected String getContents(){
        System.out.println("Type contents of the post: ");
        return scanner.nextLine();
    }

}