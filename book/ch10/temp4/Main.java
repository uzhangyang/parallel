package book.ch10.temp4;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("c:\\Windows", "log");
//		FolderProcessor apps = new FolderProcessor("c:\\Program Files", "log");
//		FolderProcessor documents = new FolderProcessor("c:\\Documents And Settings", "log");
        pool.execute(system);
//		pool.execute(apps);
//		pool.execute(documents);
        do {
            System.out.println("**********************************************");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task counts: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Parallelism %d\n", pool.getStealCount());
            System.out.println("**********************************************");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!system.isDone());
//		}while((!system.isDone())||(!apps.isDone()) || (!documents.isDone()));
        pool.shutdown();
        List<String> results;
        results = system.join();
        System.out.printf("System: %d files found. \n", results.size());

//		results = apps.join();
//		System.out.printf("apps: %d files found. \n", results.size());
//		
//		results = documents.join();
//		System.out.printf("documents: %d files found. \n", results.size());

    }
}
