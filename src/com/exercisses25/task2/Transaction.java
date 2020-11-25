package com.exercisses25.task2;

public class Transaction implements Runnable{
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {

        synchronized (src){
            if (src.getBalance() <money) {
                System.out.println("Sorry your balance is to low for thise operation");
                return;
            } else {
                src.setBalance(src.getBalance()-money);
            }
        }
            synchronized (dst){
                dst.setBalance(dst.getBalance()+money);
        }

        // TODO перевод денежных средств со счета src на счет dst
        //  в количестве money
    }
}