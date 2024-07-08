package book.ch5.atomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAThread extends Thread {

    AtomicStampedReference<Integer> asr;

    public ABAThread(AtomicStampedReference<Integer> asr) {
        this.asr = asr;
    }

    @Override
    public void run() {
        asr.compareAndSet(0, 1, asr.getStamp(), asr.getStamp()+1);
        System.out.println("已经将值由0改为1");
        asr.compareAndSet(1, 0, asr.getStamp(), asr.getStamp()+1);
        System.out.println("已经将值由1改为0");
    }
}
