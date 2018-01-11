package com.company.options.AdminOptions;

import com.company.Forum;
import com.company.User;

public class PromoteToAdmin extends AdminOption{

    public PromoteToAdmin(){
        this.optionName = "Promote to admin";
    }

    @Override
    public boolean start() {
        String name = getName("User");
        for (User user : Forum.getInstance().getUserList()){
            if (user.getNick().equals(name)) {
                Forum.getInstance().getUserList().remove(user);
                Forum.getInstance().getAdminList().add(user);
            }
        }
        return true;
    }
}
