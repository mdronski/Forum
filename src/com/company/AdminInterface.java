package com.company;

import com.company.options.AdminOptions.AdminOption;
import com.company.options.AdminOptions.GoBackFromAdmin;
import com.company.options.SubForumOptions.SubForumOption;
import com.company.options.ThreadOptions.ThreadOption;

import java.util.List;

public class AdminInterface extends UserInterface {

    private boolean adminOptionsExit = false;

    public AdminInterface(User user, List<SubForumOption> subForumOptions, List<ThreadOption> threadOptions) {
        super(user, subForumOptions, threadOptions);
    }


    @Override
    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();

        for(SubForumOption option : subForumOptions){

            System.out.print(subForumOptions.indexOf(option) + ". ");
            System.out.print(option.toString());
        }
        System.out.println((subForumOptions.size()) + ". Admin options");

        int optionNumber = Forum.getOptionNumber(0,subForumOptions.size());
        System.out.println();
        if (optionNumber < subForumOptions.size()) {
            subForumOptions.get(optionNumber).start(this);
        }   else {
            handleAdminOptionsSession();
        }
        cleanConsole();
        System.out.println();
    }

    private void handleAdminOptionsSession(){
        while (!this.adminOptionsExit){
            showAdminOptions();
            cleanConsole();
        }
        this.adminOptionsExit = false;
    }

    private void showAdminOptions(){
        for (AdminOption adminOption : Forum.getInstance().getAdminOptions()){
            System.out.print(Forum.getInstance().getAdminOptions().indexOf(adminOption) + ". ");
            System.out.print(adminOption.toString());
        }
        System.out.println();
        int optionNumber = Forum.getOptionNumber(0 ,Forum.getInstance().getAdminOptions().size()-1);
        System.out.println();
        Forum.getInstance().getAdminOptions().get(optionNumber).start();
        if (Forum.getInstance().getAdminOptions().get(optionNumber) instanceof GoBackFromAdmin){
            this.adminOptionsExit = true;
        }
    }

}
