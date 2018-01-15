package com.company;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ReaderClass {

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
