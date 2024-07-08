package book.ch10.maximum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class MaxTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
    Integer[] bigData;
    int start;
    int end;
    int threshold;
    int nthreads;

    public MaxTask(Integer[] bigData, int start, int end, int nthreads, int threshold) {
        this.bigData = bigData;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
        this.nthreads = nthreads;
    }

    @Override
    protected Integer compute() {
        Integer result;
        if (end - start <= threshold) {
            result = computeSequential();
        } else {
            System.out.println("类MaxTask: 开始fork操作...");
            int scale = (end - start + nthreads - 1) / nthreads;
            System.out.println("类MaxTask:每段数据的长度为 " + scale);
            int[] len = new int[nthreads + 1];
            for (int i = 0; i <= nthreads; i++) {
                len[i] = scale * i;
                if (len[i] > end)
                    len[i] = end;
            }
            MaxTask[] tasks = new MaxTask[nthreads];
            System.out.printf("类MaxTask: %d个任务被创建\n", nthreads);
            for (int i = 0; i < nthreads; i++) {
                tasks[i] = new MaxTask(bigData, len[i], len[i + 1],nthreads, threshold);
            }
            invokeAll(tasks);
            List<Integer> results = new ArrayList<Integer>();
            try {
                for (int i = 0; i < nthreads; i++){
                    Integer re = tasks[i].get();
                    System.out.printf("类MaxTask: 任务%d的结果是%d\n", i, re);
                    results.add(re);
                }

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            result = max(results);
        }
        return result;
    }

    private Integer computeSequential() {
        Integer max = bigData[start];
        for (int i = start + 1; i < end; i++) {
            if (max < bigData[i])
                max = bigData[i];
        }
        return max;
    }

    private Integer max(List<Integer> results) {
        Integer m = 0;
        for (Integer result : results) {
            if (m < result)
                m = result;
        }
        return m;
    }
}
