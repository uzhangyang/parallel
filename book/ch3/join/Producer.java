package book.ch3.join;

public class Producer implements Runnable {
    int[] arr;

    public Producer(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }
}
