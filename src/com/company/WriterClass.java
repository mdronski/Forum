package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriterClass {


    public static void write(Object object, String filePath){

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(object);

        } catch (Exception e){

            e.printStackTrace();

        }finally {
            if (fout != null){
                try {
                    fout.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeAllForum(){
        Forum forum = Forum.getInstance();
        write(forum.getMainForum(), "MainForum.ser");
        write(forum.getUserList(), "UserList.ser");
        write(forum.getAdminList(), "AdminList.ser");
    }

}
