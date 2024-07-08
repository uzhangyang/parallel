package book.ch4.deadlock;

public class Data {
    int a = 0;
    int b = 0;
    String str = "Data";

    public synchronized void increase() {
        synchronized (str) {
            a++;
            b++;
        }
    }

    public void isEqual() {
        synchronized (str) {
            synchronized (this) {
                System.out.println("a=" + a + "\tb=" + b + "\t" + (a == b));
            }
        }

    }
}
