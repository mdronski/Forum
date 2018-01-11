package com.company;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ReaderClass {

    private static Scanner scanner = new Scanner(System.in);

    public static Object read(String fileName){

        Object object = null;

        try(ObjectInputStream ois
                    = new ObjectInputStream(new FileInputStream(fileName))){
            object = ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
}
