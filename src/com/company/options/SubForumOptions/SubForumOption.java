package com.company.options.SubForumOptions;

import com.company.UserInterface;
import com.company.options.Option;


import java.io.Serializable;
import java.util.Scanner;

public abstract class SubForumOption extends Option implements Serializable {


    public abstract boolean start(UserInterface ui);

    @Override
    public String toString() {
        return  optionName + "  ";
    }
}
