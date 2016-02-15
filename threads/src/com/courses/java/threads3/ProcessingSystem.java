package com.courses.java.threads3;

public class ProcessingSystem implements Runnable {

    static Account account;
    Lock lock = new Lock();

    public static void main(String[] args) throws InterruptedException {
        account = new Account(100);
        Thread anna = new Thread(new ProcessingSystem());
        Thread john = new Thread(new ProcessingSystem());

        anna.start();
        john.start();

        anna.join();
        john.join();

        System.out.println(account.getMoney());
    }

    @Override
    public void run() {
        lock.lock();
        if (account.getMoney() >= 100) {
            account.withdraw(100);
        }
        lock.unlock();
    }
}
