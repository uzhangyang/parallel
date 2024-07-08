package book.ch5.AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

public class Customer extends Thread {

    int id;
    Account account;
    AtomicReference<Account> ar;

    Customer(int id, AtomicReference<Account> ar) {
        this.ar = ar;
    }

    public void run() {
        ar.compareAndSet(account, new Account("zhang", account.saveMoney(2000)));
        System.out.println();

    }
}
