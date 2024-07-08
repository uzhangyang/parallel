package book.ch5.atomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Index {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(0, 0);
        ABAThread abaThread = new ABAThread(asr);
        NormalThread normalThread = new NormalThread(asr);
        normalThread.start();
        abaThread.start();

    }
}
