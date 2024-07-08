package book.ch9.future;

import java.util.concurrent.Callable;

public class Student implements Callable<Long> {

    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public Long call() {
        System.out.println(name +"开始考试.");
        long start = System.nanoTime();
        int num =  (int)(Math.random()*Integer.MAX_VALUE);
        for(int i=0; i<num; i++);
        long end = System.nanoTime();
        System.out.println(name +"考试完毕");
        Long time = end - start;
        return time;
    }

    public String getName() {
        return name;
    }
}
