package book.ch4.stampedlock;

public class RThread extends Thread {

    IntList il;

    RThread(IntList il) {
        this.il = il;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            il.getOptimistic(i);
        }
    }


}
