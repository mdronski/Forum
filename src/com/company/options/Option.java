package com.company.options;

import java.io.Serializable;
import java.util.Scanner;

public class Option implements Serializable{

    public String optionName;
    protected static Scanner scanner = new Scanner(System.in);


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

    @Override
    public String toString() {
        return optionName + "   ";
    }
}
