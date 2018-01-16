package com.company.options;

import com.company.Forum;

import java.io.Serializable;
import java.util.Scanner;

public class Option implements Serializable{

    public String optionName;
    protected static Scanner scanner = new Scanner(System.in);


    protected int getNumber(String option, int minValue, int maxValue){
        System.out.println("Choose " + option);
        int number = Forum.getOptionNumber(minValue, maxValue);
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
