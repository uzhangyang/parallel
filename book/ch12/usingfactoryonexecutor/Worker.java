package book.ch12.usingfactoryonexecutor;

public class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始工作");
        doSomthing();
        System.out.println(Thread.currentThread().getName()+"工作结束");

    }

    private void doSomthing() {
        int number = (int) (Math.random() * 100);
        for (int i = 1, fac = 1; i <= number; i++)
            fac = fac * i;
    }
}
