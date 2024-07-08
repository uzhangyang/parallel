package book.ch4.stampedlock;

public class WThread extends Thread {
    IntList il;

    WThread(IntList il) {
        this.il = il;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            il.insert(i);
        }
    }
}
