package book.ch5.aba;

import java.util.concurrent.atomic.AtomicReference;

public class NormalThread extends Thread {
    AtomicReference<Integer> ar;

    public NormalThread(AtomicReference<Integer> ar) {
        this.ar = ar;
    }

    @Override
    public void run() {
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(ar.compareAndSet(0, 1))
            System.out.println("更新成功");
        else
            System.out.println("更新失败");



    }
}
