package book.ch5.atomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class NormalThread extends Thread {
    AtomicStampedReference<Integer> asr;

    public NormalThread(AtomicStampedReference<Integer> asr) {
        this.asr = asr;
    }

    @Override
    public void run() {
        int stamp = asr.getStamp();
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(asr.compareAndSet(0, 1, stamp, stamp+1))
            System.out.println("更新成功");
        else
            System.out.println("更新失败");



    }
}
