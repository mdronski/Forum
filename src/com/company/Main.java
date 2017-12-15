package com.company;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        User u1 = new User("Michal", "Dronski", "mdronski", "haslo");
        User u2 = new User("Chuck", "Norris", "chucknorris123", "chuckmabyc");
        Forum.getInstance().addNewUser(u1, false);
        Forum.getInstance().addNewUser(u2, false);

       for(User user : Forum.getInstance().getUserList()){
           System.out.println(user);
       }

    }
}
