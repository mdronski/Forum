package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class User implements Serializable {

    private String nick;
    private String password;
    private final LocalDate registrationDate;
    private Integer postsCount;
    private boolean isBanned;

    public User(String nick, String password) {

        this.nick = nick;
        this.registrationDate = LocalDate.now();
        this.postsCount = 0;
        this.password = password;
        this.isBanned = false;
    }



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

    public void setBanned(boolean banned) {
        isBanned = banned;
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
