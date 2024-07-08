package book.ch6.runnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Index {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Worker();
        FutureTask<String> ftask = new FutureTask<String>(runnable, "发射成功");
        Thread thread = new Thread(ftask);
        thread.start();
        while(true){
            if(ftask.isDone()){
                System.out.println(ftask.get());
                break;
            }

        }
    }
}
