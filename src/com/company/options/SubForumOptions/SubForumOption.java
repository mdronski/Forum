package com.company.options.SubForumOptions;

import com.company.UserInterface;

import java.io.Serializable;
import java.util.Scanner;

public abstract class SubForumOption implements Serializable {

    public String optionName;

    private static Scanner scanner = new Scanner(System.in);

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

    @Override
    public String toString() {
        return  optionName + "  ";
    }
}
