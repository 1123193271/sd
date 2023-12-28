package com.study.xyl._08_preventRepeat.T;

import lombok.Getter;

import javax.persistence.Entity;

@Getter
public class User {
    private String userName;

    private String name;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
