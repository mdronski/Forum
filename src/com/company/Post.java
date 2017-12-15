package com.company;

import java.util.Date;

public class Post {

    private User user;
    private Date date;
    private String contents;

    public Post(User user, Date date, String contents) {
        this.user = user;
        this.date = date;
        this.contents = contents;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(contents);
        sb.append(System.getProperty("line.separator"));
        sb.append(date.toString() + "   " + user.toString());
        return sb.toString();
    }

}
