package book.ch6.FileFinder2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

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

        List<CompletableFuture<?>> cfList = new ArrayList<CompletableFuture<?>>();

        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                searchFolder(file, fileName, executor);
            }
        }, executor);

    }

    static void searchFolder(File file, String fileName, ExecutorService executor) {
        assert (file != null);
        File[] files = file.listFiles();
        assert (files != null);
        for (File fileTemp : files) {
            if (fileTemp.isDirectory()) {
                CompletableFuture.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        searchFolder(fileTemp, fileName, executor);
                    }
                }, executor);
            } else {
                if (fileTemp.getName().equals(fileName)) {
                    System.out.println("文件'" + fileName + "'在" + fileTemp.getAbsolutePath() + "文件夹下被找到");
                    executor.shutdown();
                }
            }
        }
    }

}
