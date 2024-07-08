package book.ch5.AtomicIntegerArray2;

import java.util.concurrent.atomic.AtomicInteger;

public class Index {
    public static void main(String[] args) {
        AtomicInteger[] ai = new AtomicInteger[10000];
        for (int i = 0; i < 10000; i++) {
            ai[i] = new AtomicInteger(0);
        }
        System.out.println("初始化完毕。");
        Thread w1 = new Worker("工人1", ai);
        Thread w2 = new Worker("工人2", ai);
        Thread w3 = new Worker("工人3", ai);
        Thread w4 = new Worker("工人4", ai);
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        try{
            w1.join();
            w2.join();
            w3.join();
            w4.join();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        for(int i=0; i<10000; i++){
            if(ai[i].get()!=4){
                System.out.println("验证失败！");
                break;
            }
        }

    }
}
