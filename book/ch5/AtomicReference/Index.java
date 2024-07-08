package book.ch5.AtomicReference;


import java.util.concurrent.atomic.AtomicReference;

public class Index {
    public static void main(String[] args) {
        Account account = new Account("zhang", 20000);
        AtomicReference<Account> af = new AtomicReference<Account>(account);
        for(int i=1; i<=5; i++){
            new Customer(i, af).start();
        }
    }

}
