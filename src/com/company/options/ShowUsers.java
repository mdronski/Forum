package com.company.options;

import com.company.Forum;

public class ShowUsers extends AdminOption {

    public ShowUsers(){
        this.optionName = "Show all users";
    }

    @Override
    public boolean start() {
        System.out.println(Forum.getInstance().getUserList());
        System.out.println();
        return true;
    }
}
