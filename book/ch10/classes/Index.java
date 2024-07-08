package book.ch10.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Index {
    public static void main(String[] args) {
        int nthreads = Runtime.getRuntime().availableProcessors();
        int threshold = 10;
        int increment = 5;
        int baseNum = 50;
        int size = 100000;
        List<ClassInfo> infos = new ArrayList<ClassInfo>();
        for (int i = 0; i < size; i++) {
            ClassInfo classInfo = new ClassInfo("�༶" + i, baseNum);
            infos.add(classInfo);
        }
        ForkJoinPool pool = new ForkJoinPool();
        UpdateTask updateTask = new UpdateTask(infos, 0, infos.size(), increment, nthreads, threshold);
        pool.execute(updateTask);
        do {
			System.out.printf("类Index: 并行度: %d\n", pool.getParallelism());
            System.out.printf("类Index: 活动线程数: %d\n", pool.getActiveThreadCount());
            System.out.printf("类Index: 任务数: %d\n", pool.getQueuedTaskCount());
            System.out.printf("类Index: 窃取任务数: %d\n", pool.getStealCount());
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }while(!updateTask.isDone());
        if(validate(infos, baseNum + increment)){
            System.out.println("所有班级更新完毕");
        } else {
            System.out.println("Something wrong happened.");
        }
        pool.shutdown();
    }

    private static boolean validate(List<ClassInfo> infos, int total) {
        boolean pass = true;
        for (ClassInfo info : infos) {
            if (info.getNumber() != total)
                pass = false;
        }
        return pass;
    }
}
