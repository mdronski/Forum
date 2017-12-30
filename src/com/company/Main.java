package com.company;

public class Main {

    public static void main(String[] args) {

        User u1 = new User("Michal", "Dronski", "mdronski", "haslo");
        User u2 = new User("Chuck", "Norris", "chucknorris123", "chuckmabyc");
        Forum.getInstance().addNewUser(u1, false);
        Forum.getInstance().addNewUser(u2, false);

        Post p1 = new Post("szukam pracy", u1);
        Post p2 = new Post("przyjme gruz", u1);
        Post p3 = new Post("udziele korepetycji", u1);
        Post p4 = new Post("naprawie komputer", u2);
        Post p5 = new Post("co ty gadasz", u2);
        Post p6 = new Post("sprzedam opla", u1);
        Post p7 = new Post("austriacki akwarelista", u1);
        Post p8 = new Post("jp2", u2);

        Thread t1 = new Thread("thread 1", u1);
        t1.addPost(p1);
        t1.addPost(p2);
        t1.addPost(p3);

        Thread t2 = new Thread("thread 2", u1);
        t2.addPost(p4);
        t2.addPost(p6);
        t2.addPost(p8);

        Thread t3 = new Thread("thread 3", u2);
        t3.addPost(p5);
        t3.addPost(p7);


        SubForum s1 = new SubForum("subforum 1");
        s1.addThread(t1);
        s1.addThread(t2);

        SubForum s2 = new SubForum("subforum 2");
        s2.addThread(t3);

        s1.addSubForum(s2);

        //System.out.println(s1);
        //System.out.println(t1);

        Forum.getInstance().setMainForum(s1);
        //UserInterface UI = LoginClass.logIn();

        //UI.showSubForumInterface();
         WriterClass.write(Forum.getInstance(), "ForumFile.ser");




    }
}
