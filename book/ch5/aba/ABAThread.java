package book.ch5.aba;

import java.util.concurrent.atomic.AtomicReference;

public class ABAThread extends Thread {

    AtomicReference<Integer> ar;

    public ABAThread(AtomicReference<Integer> ar) {
        this.ar = ar;
    }

    @Override
    public void run() {
        ar.compareAndSet(0, 1);
        System.out.println("已经将值由0改为1");
        ar.compareAndSet(1, 0);
        System.out.println("已经将值由1改为0");
    }
}
