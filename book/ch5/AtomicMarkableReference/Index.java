package book.ch5.AtomicMarkableReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class Index {
    public static void main(String[] args) {
        AtomicMarkableReference<Integer> amr = new AtomicMarkableReference<Integer>(0, false);
        Thread ta = new Worker(amr, "A");
        Thread tb = new Worker(amr, "B");
        ta.start();
        tb.start();
    }
}	
