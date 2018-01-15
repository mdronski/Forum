package com.company;

import java.util.Scanner;

public class LoginClass {

    private static Scanner scanner = new Scanner(System.in);

    private static UserInterface logIn(){
        String login = getString("login");
        String password = getString("password");

        while (!Forum.getInstance().checkUser(Forum.getInstance().getUser(login, password))){
            System.out.println("Login or password is incorrect, try again");
            login = getString("login");
            password = getString("password");
        }

        User user = Forum.getInstance().getUser(login, password);

        if (user.isBanned()){
            System.out.println("You are banned!");
            return null;
        }

        if (Forum.getInstance().checkAdmin(user)){
            return new AdminInterface(user,Forum.getInstance().getAdminSubForumOptions() ,Forum.getInstance().getAdminThreadOptions());
        }
            return new UserInterface(user, Forum.getInstance().getUserSubForumOptions(), Forum.getInstance().getUserThreadOptions());

    }

    public static UserInterface loginInterface(){
        System.out.println("1. Log in");
        System.out.println("2. Create account");
        System.out.println("3. Exit");
        System.out.println();
        int option = Forum.getOptionNumber(1,3);
        switch (option){
            case 1:
                return logIn();
            case 2:
                return createAccount();
            case 3:
                return null;
        }
        return null;
    }

    private static String getString(String s){
        System.out.println("Enter " + s);
        String var = scanner.nextLine();
        System.out.println();
        return var;
    }

    private static UserInterface createAccount(){
       String nick = getString("nickName");
       String password = getString("password");
         while (!Forum.getInstance().addNewUser(new User(nick, password))){
             nick = getString("nickName");
         }
         return new UserInterface(Forum.getInstance().getUser(nick, password), Forum.getInstance().getUserSubForumOptions(), Forum.getInstance().getUserThreadOptions());
    }


}
