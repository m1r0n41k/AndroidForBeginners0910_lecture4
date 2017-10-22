package com.drondon;

public class EmailContact implements Contact {

    private String name;
    private String email;

    public EmailContact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getData() {
        return email;
    }
}
