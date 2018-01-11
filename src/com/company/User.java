package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class User implements Serializable {

//    private String firstName;
//    private String lastName;
    private String nick;
    private String password;
    private final LocalDate registrationDate;
    private Integer postsCount;

    public User(String nick, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
        this.nick = nick;
        this.registrationDate = LocalDate.now();
        this.postsCount = 0;
        this.password = password;
    }


//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }

    public String getNick() {
        return nick;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Integer getPostsCount() {
        return postsCount;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return nick;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof User)){
            return false;
        }

        User user = (User) object;
        return this.nick.equals(user.getNick());
    }
}
