package com.company.options.ThreadOptions;

import com.company.User;
import com.company.Thread;
import com.company.options.Option;


import java.io.Serializable;
import java.util.Scanner;


public abstract class ThreadOption extends Option implements Serializable {


        public abstract boolean start(Thread thread, User user);


    protected String getContents(){
        System.out.println("Type contents of the post: ");
        return scanner.nextLine();
    }

}
