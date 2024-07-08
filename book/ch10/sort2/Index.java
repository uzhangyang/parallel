package book.ch10.sort2;

import java.util.concurrent.ForkJoinPool;

public class Index {

    public static void main(String[] args){
        final int N = 2000;
        long[] array = new long[N];
        System.out.println("已经生成了"+N+"个数据");
        for(int i=0; i<N; i++){
            array[i] = (long) (Math.random()*N);
        }
        ForkJoinPool pool = new ForkJoinPool(2);
        System.out.println("线程池已经准备好，开始排序...");
        SortTask st = new SortTask(array);
        pool.execute(st);
        st.join();
        System.out.println("排序完成，马上关闭线程池...");
        pool.shutdown();
    }


}
