package book.ch5.aba;

import java.util.concurrent.atomic.AtomicReference;

public class Index {
    public static void main(String[] args) {
        AtomicReference<Integer> ar = new AtomicReference<Integer>(0);
        ABAThread abaThread = new ABAThread(ar);
        NormalThread normalThread = new NormalThread(ar);
        abaThread.start();
        normalThread.start();
    }
}
