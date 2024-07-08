package book.ch5.AtomicMarkableReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class Worker extends Thread {

    AtomicMarkableReference<Integer> amr;

    public Worker(AtomicMarkableReference<Integer> amr, String name) {
        this.amr = amr;
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程"+name+"读到的原子标记初始值为："
                +amr.isMarked());
        if(amr.compareAndSet(0, 1, false, true)){
            System.out.println("线程"+name+
                    "操作的原子标记当前值为："+amr.isMarked());
            System.out.println("线程"+name+"正在将原子标记的值由0设置为1");
        }else{
            System.out.println("线程"+name+"原子操作没有成功");
        }

    }
}
