package book.ch12.customizedforkjointask;

import java.util.concurrent.ForkJoinTask;

public abstract class CustomizedRecursiveAction extends ForkJoinTask<Void> {

    @Override
    protected boolean exec() {
        long start = System.nanoTime();
        compute();
        long end = System.nanoTime();
        System.out.println("执行时间为:"+(end-start)+"纳秒");
        return true;
    }

    @Override
    public Void getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Void result) {
    }

    protected abstract void compute();

}
