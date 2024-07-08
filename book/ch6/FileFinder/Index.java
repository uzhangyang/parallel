package book.ch6.FileFinder;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 在能够找到文件的情况下的处理情况
public class Index {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 指明搜索的文件夹
        String dir = "c:\\windows\\";
        // 需要查找的文件名
        String fileName = "nrpsrv.dll";
        assert (new File(dir).isDirectory());
        File file = new File(dir);
        // 定义线程池执行器
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // 使用异步任务来查找
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                searchFolder(file, fileName, executor);
            }
        }, executor);
    }
    // 该方法用于递归地查找
    static void searchFolder(File file, String fileName, ExecutorService executor) {
        assert (file != null);
        //获取当前文件夹下的所有文件夹和文件
        File[] files = file.listFiles();
        assert (files != null);
        for (File fileTemp : files) {
            // 如果是一个目录，则生成一个新的异步任务用于查找
            if (fileTemp.isDirectory()) {
                CompletableFuture.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        searchFolder(fileTemp, fileName, executor);
                    }
                }, executor);
            } else {
                //如果找到文件，则输出，并关闭线程池
                if (fileTemp.getName().equals(fileName)) {
                    System.out.println("文件'" + fileName + "'在" + fileTemp.getAbsolutePath() );
                    executor.shutdown();
                }
            }
        }
    }


}
