package com.courses.java;

public class InsufficientMoney extends Exception {

    int shortage;

    public int getShortage() {
        return shortage;
    }

    public void setShortage(int shortage) {
        this.shortage = shortage;
    }

    public InsufficientMoney(String message) {
        super(message);
    }

    public InsufficientMoney(String message, Throwable t) {
        super(message, t);
    }
}
