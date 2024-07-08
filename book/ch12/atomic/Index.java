package book.ch12.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Index {

    public static void main(String[] args) {
        int nthreads = 4;
        Counter counter = new Counter();
        Selector[] selectors = new Selector[nthreads];
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        for (int i = 0; i < nthreads; i++) {
            selectors[i] = new Selector(counter);
            FutureTask<Integer> task = new FutureTask<Integer>(selectors[i]);
            taskList.add(task);
            Thread t = new Thread(task);
            t.start();
        }
        int sum = 0;
        for (FutureTask<Integer> task : taskList) {
            try {
                sum += task.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nthreads+"个任务的总数为:"+sum);
        System.out.println("counter.get()=" + counter.get());
    }

}
