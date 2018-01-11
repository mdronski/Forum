package com.company.options.AdminOptions;

import com.company.Forum;
import com.company.User;

public class BannUser extends AdminOption {

    public BannUser(){
        this.optionName = "Bann user";
    }

    @Override
    public boolean start() {
        User user = Forum.getInstance().getUser(getUserNick());
        if (Forum.getInstance().getUserList().contains(user)){
            if (Forum.getInstance().checkAdmin(user)){
                System.out.println("You cannot ban an admin!");
            }else {
                user.setBanned(true);
            }
        }else {
            System.out.println("User with this nick does not exists!");
        }
        return false;
    }
}
