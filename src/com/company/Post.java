package com.company;

import java.time.LocalDate;
import java.util.Date;

public class Post {

    private User user;
    private LocalDate date;
    private String contents;

    public Post( String contents, User user) {
        this.user = user;
        this.date = LocalDate.now();
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContents() {
        return contents;
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
