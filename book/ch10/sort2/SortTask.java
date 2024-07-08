package book.ch10.sort2;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class SortTask extends RecursiveAction {
    static final int THRESHOLD = 1000;

    final long[] array;
    final int low, high;

    SortTask(long[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    SortTask(long[] array) {
        this(array, 0, array.length);
    }

    protected void compute() {
        if (high - low < THRESHOLD)
            sortSequentially(low, high);
        else {
            int mid = (low + high) >>> 1;
            System.out.println("开始派生任务, low=" + low + ",high=" + high);
            invokeAll(new SortTask(array, low, mid),
                    new SortTask(array, mid, high));
            merge(low, mid, high);
        }
    }

    void sortSequentially(int lo, int hi) {
        Arrays.sort(array, lo, hi);
    }

    void merge(int lo, int mid, int hi) {
        long[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++)
            array[j] = (k == hi || buf[i] < array[k]) ?
                    buf[i++] : array[k++];
    }
}
