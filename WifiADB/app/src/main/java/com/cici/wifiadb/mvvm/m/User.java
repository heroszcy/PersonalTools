package com.cici.wifiadb.mvvm.m;

import android.databinding.BaseObservable;

/**
 *
 * @author zhaochongyou
 * @date 2018/4/8
 */

public class User extends BaseObservable{
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}
