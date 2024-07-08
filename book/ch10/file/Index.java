package book.ch10.file;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Index {
    public static void main(String[] args) {
        String dir = "c:\\windows\\";
        assert (new File(dir).isDirectory());
        ForkJoinPool pool = new ForkJoinPool();
        FileFinderTask task = new FileFinderTask(dir, "nrpsrv.dll");
        pool.execute(task);
        String findedPath = task.join();
        if (findedPath == null) {
            System.out.println("文件没有找到.");
        }
        pool.shutdown();
    }
}
