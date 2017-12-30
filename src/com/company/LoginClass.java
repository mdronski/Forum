package com.company;

import java.util.Scanner;

public class LoginClass {

    private static Scanner scanner = new Scanner(System.in);

     public static UserInterface logIn(){
        String login = getLogin();
        String password = getPassword();
        while (!Forum.getInstance().checkUser(login, password)){
            System.out.println("Wprowadzono niepoprawne dane, wpisz je ponownie: ");
            login = getLogin();
            password = getPassword();
        }
        if (Forum.getInstance().checkAdmin(login, password)){
            return new UserInterface(Forum.getInstance().getUser(login, password),Forum.getInstance().getUserSubForumOptions() ,Forum.getInstance().getAdminThreadOptions());
        }
            return new UserInterface(Forum.getInstance().getUser(login, password), Forum.getInstance().getUserSubForumOptions(), Forum.getInstance().getUserThreadOptions());

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


}
