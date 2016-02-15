package com.courses.java.threads3;

public class Account {
    int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void withdraw(int summa) {
        money = money - summa;
    }
}
