package com.courses.java;

public class User {

    public static void main(String[] args) {


        try (ATM atm = new ATM()) {
            atm.getMoney(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
