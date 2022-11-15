package com.kalew515.example.pojo;

public class Hello {
    private String message;
    private String description;

    public Hello () {
    }

    public Hello (String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}
