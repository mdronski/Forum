package com.company;

import java.util.Scanner;

public class LoginClass {

    private static Scanner scanner = new Scanner(System.in);

     public static UserInterface logIn(){
        String login = getLogin();
        String password = getPassword();
        while (!Forum.getInstance().checkUser(Forum.getInstance().getUser(login, password))){
            System.out.println("Wprowadzono niepoprawne dane, wpisz je ponownie: ");
            login = getLogin();
            password = getPassword();
        }
        User user = Forum.getInstance().getUser(login, password);
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
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1:
                return logIn();
            case 2:
                return createAccount();
            case 3:
                break;

            default:
                System.out.println("wrong number!");
                return loginInterface();

        }
        return null;
    }


    private static String getLogin(){
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        System.out.println();
        return login;
    }

    private static String getPassword(){
        System.out.println("Podaj hasło: ");
        String passw = scanner.nextLine();
        System.out.println();
        return passw;
    }

    private static String getString(String s){
        System.out.println("Podaj " + s);
        String var = scanner.nextLine();
        System.out.println();
        return var;
    }

    public static UserInterface createAccount(){
       String nick = getString("nickName");
       String password = getString("password");
         while (!Forum.getInstance().addNewUser(new User(nick, password))){
             nick = getString("nickName");
         }
         return new UserInterface(Forum.getInstance().getUser(nick, password), Forum.getInstance().getUserSubForumOptions(), Forum.getInstance().getUserThreadOptions());
    }


}
