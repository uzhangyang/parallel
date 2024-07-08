package book.ch6.callable;

import java.util.concurrent.Callable;

public class Worker implements Callable<Integer> {

    Integer arr[];
    int begin;
    int end;

    Worker(Integer arr[], int begin, int end) {
        this.arr = arr;
        this.begin = begin;
        this.end = end;
    }

    public Integer call() {
        Integer max = arr[begin];
        for (int i = begin + 1; i < end; i++)
            if (max < arr[i])
                max = arr[i];
        return max;
    }
}
