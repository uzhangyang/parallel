package book.ch3.interrupt;

public class Index {
    public static void main(String[] args) {
        Thread newThread = new LeapYearPrinter();
        newThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newThread.interrupt();
    }
}
