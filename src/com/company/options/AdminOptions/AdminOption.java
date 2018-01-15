package com.company.options.AdminOptions;

import com.company.UserInterface;
import com.company.options.Option;


import java.io.Serializable;


public abstract class AdminOption extends Option implements Serializable {

    public abstract boolean start();

    protected String getUserNick(){
        System.out.println("Type user nick to be banned: ");
        return scanner.nextLine();
    }

}
