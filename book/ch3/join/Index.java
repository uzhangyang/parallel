package book.ch3.join;

public class Index {
    static int sum = 0;

    public static void main(String[] args) {
        int[] arr = new int[100000];
        Thread p = new Thread(new Producer(arr));
        p.start();
        Thread w = new Thread(new Worker(arr, p));
        w.start();
        Thread o = new Thread(new PrintTask(w));
        o.start();
        try {
            o.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            t += arr[i];
        }
        if (t == sum) {
            System.out.println("验证通过！");
        } else {
            System.out.println("验证失败. t=" + t + ", sum=" + sum);
        }

    }
}
