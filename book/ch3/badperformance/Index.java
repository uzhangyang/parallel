package book.ch3.badperformance;

public class Index {

    public static void main(String[] args) {
        int threadNum = 100;
        long start1 = System.nanoTime();
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Printer();
            threads[i].start();
        }
        for (int i = 0; i < threadNum; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        for(int i=0;i<threadNum; i++){
            System.out.println("正在输出:"+i);
        }
        long end2 = System.nanoTime();
        System.out.println("使用线程的执行时间为"+(end1-start1)+"纳秒");
        System.out.println("串行的执行时间为"+(end2-start2)+"纳秒");

    }

}
