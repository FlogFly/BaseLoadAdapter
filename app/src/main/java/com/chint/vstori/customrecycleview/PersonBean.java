package com.chint.vstori.customrecycleview;

/**
 * Project:CustomRecycleView
 * Author:dyping
 * Date:2017/7/6 19:04
 */

public class PersonBean {

    private String name;
    private String email;

    public PersonBean(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
