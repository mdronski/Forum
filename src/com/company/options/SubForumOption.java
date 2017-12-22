package com.company.options;

import com.company.UserInterface;

import java.util.Scanner;

public abstract class SubForumOption {

    public String optionName;
    private Scanner scanner = new Scanner(System.in);

    public abstract boolean start(UserInterface ui);

    protected String getName(String option){
        System.out.println("Type " + option +  "name: ");
        return scanner.nextLine();
    }

    protected int getNumber(String option){
        System.out.println("Choose " + option);
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("You choosed " + option + " " + number);
        return number;
    }
}
