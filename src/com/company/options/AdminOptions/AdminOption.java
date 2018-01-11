package com.company.options.AdminOptions;

import com.company.UserInterface;

import java.io.Serializable;
import java.util.Scanner;

public abstract class AdminOption implements Serializable {

    public String optionName;

    private static Scanner scanner = new Scanner(System.in);

    public abstract boolean start();

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

    protected String getUserNick(){
        System.out.println("Type user nick to be banned: ");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return  optionName + "  ";
    }

}
