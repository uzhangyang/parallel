package book.ch3.max;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) {
        int n = 50000;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * n);
        }
        //���
        int nthreads = 2; // 2�߳�
        int mid = n / nthreads;
        Integer[] arr1 = Arrays.copyOfRange(a, 0, mid - 1);
        Integer[] arr2 = Arrays.copyOfRange(a, mid, n - 1);
        Callable<Integer> c1 = new FindTask(arr1);
        Callable<Integer> c2 = new FindTask(arr2);
        FutureTask<Integer> task1 = new FutureTask<>(c1);
        FutureTask<Integer> task2 = new FutureTask<>(c2);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        Integer m1 = null;
        Integer m2 = null;
        try {
            m1 = task1.get();
            m2 = task2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (m1 > m2)
            System.out.println(m1);
        else
            System.out.println(m2);

    }

}
