package book.ch11.random;

import java.util.concurrent.ThreadLocalRandom;

public class Generator extends Thread {

    Generator() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+"产生了随机数"
                    +ThreadLocalRandom.current().nextInt(100));
        }
    }
}
