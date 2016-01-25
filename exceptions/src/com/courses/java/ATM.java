package com.courses.java;

public class ATM implements AutoCloseable {

    int totalSumma;

    public ATM() {
        totalSumma = 1000;
    }

    public void getMoney(int money) throws InsufficientMoney {
        if (money > totalSumma) {
            throw new InsufficientMoney("Not enough money");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("ATM is down");
    }
}
