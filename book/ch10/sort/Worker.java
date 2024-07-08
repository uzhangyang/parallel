package book.ch10.sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class Worker extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    int[] bigData;
    int size;
    int nthreads;

    public Worker(int[] bigData) {
        this.bigData = bigData;
        size = bigData.length;
        nthreads = Const.NTHREADS;
    }

    @Override
    protected void compute() {
        // TODO Auto-generated method stub
        if (size < 10000000 || nthreads == 1) {
            Arrays.sort(bigData);
        } else {
            Worker[] workers = new Worker[nthreads];
            int len = bigData.length / nthreads;
            int[][] arrays = new int[nthreads][len];
            for (int i = 0; i < nthreads; i++) {
                System.arraycopy(bigData, i * len, arrays[i], 0, len);
                workers[i] = new Worker(arrays[i]);
            }
            invokeAll(workers);
            int mid = nthreads / 2;
            bigData = mergeAll(mid, arrays);
        }
    }

    private int[] mergeAll(int mid, int[]... arrays) {
        if (arrays == null)
            return null;
        int[][] temp = new int[mid][arrays[0].length * 2];
        if (mid < 2) {
            return merge(arrays[0], arrays[mid - 1]);
        } else {
            while (mid != 1) {
                for (int i = 0; i < mid; i++) {
                    temp[i] = merge(arrays[i], arrays[nthreads - i - 1]);
                }
                mid = mid / 2;
            }
        }
        System.gc();
        return mergeAll(mid, temp);
    }

    private int[] merge(int[] a, int[] b) {
        int asize = a.length;
        int bsize = b.length;
        int[] c = new int[asize + bsize];
        int aIndex = 0, bIndex = 0, cIndex = 0;
        if (asize > bsize) {
            for (int i = 0; i < bsize; i++) {
                if (a[aIndex] < b[bIndex]) {
                    c[cIndex++] = a[aIndex++];
                } else {
                    c[cIndex++] = b[bIndex++];
                }
            }
            for (int i = aIndex; i < asize; i++) {
                c[cIndex++] = a[aIndex++];
            }
        } else {
            for (int i = 0; i < asize; i++) {
                if (a[aIndex] < b[bIndex]) {
                    c[cIndex++] = a[aIndex++];
                } else {
                    c[cIndex++] = b[bIndex++];
                }
            }

            for (int i = bIndex; i < bsize; i++) {
                c[cIndex++] = b[bIndex++];
            }
        }
        return c;
    }

}
