package book.ch12.customizedexecutor;

public class Task implements Runnable {
    @Override
    public void run() {
        int number = (int) (Math.random() * 100);
        for (int i = 1, fac = 1; i <= number; i++)
            fac = fac * i;
    }
}
