package book.ch4.stampedlock;

public class Index {
    public static final int N = 10;

    public static void main(String[] args) {
        IntList ilist = new IntList();
        int rnumber = 5;
        int wnumber = N - rnumber;
        Thread[] rt = new Thread[rnumber];
        Thread[] wt = new Thread[wnumber];
        ilist.fillIfEmpty();
        System.out.println("开始生成"+wnumber+"个写线程...");
        for(int i=0; i<wnumber; i++){
            wt[i] = new WThread(ilist);
            wt[i].start();
        }
        System.out.println("开始生成"+rnumber+"个读线程...");
        for(int i=0; i<rnumber; i++){
            rt[i] = new RThread(ilist);
            rt[i].start();
        }

        System.out.println("执行完毕");

    }

}
