package com.company;

import com.company.options.*;

import java.util.List;

public class AdminInterface extends UserInterface {

    public AdminInterface(User user, List<SubForumOption> subForumOptions, List<ThreadOption> threadOptions) {
        super(user, subForumOptions, threadOptions);
    }

    @Override
    public void showSubForumInterface(){
        System.out.println(subForum);
        System.out.println();

        for(SubForumOption option : subForumOptions){
//                if (previousSubForums.empty() && option instanceof GoBack) {
//                    continue;
//                }
            System.out.print(subForumOptions.indexOf(option) + ". ");
            System.out.print(option.toString());
        }
        System.out.println((subForumOptions.size()+1) + ". Admin options");

        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + number);
        System.out.println();
        if (number <= subForumOptions.size()) {
            subForumOptions.get(number).start(this);
        }   else if (number == (subForumOptions.size()+1)){
            showAdminOptions();
        }
        cleanConsole();
        System.out.println();
        System.out.println();
        showSubForumInterface();
    }

    private void showAdminOptions(){
        for (AdminOption adminOption : Forum.getInstance().getAdminOptions()){
            System.out.print(Forum.getInstance().getAdminOptions().indexOf(adminOption) + ". ");
            System.out.print(adminOption.toString());
        }
        System.out.println();
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("you chosed option number: " + number);
        System.out.println();
        Forum.getInstance().getAdminOptions().get(number).start();
        if (!(Forum.getInstance().getAdminOptions().get(number) instanceof GoBackFromAdmin)){
            cleanConsole();
            showAdminOptions();
        }
    }

}
