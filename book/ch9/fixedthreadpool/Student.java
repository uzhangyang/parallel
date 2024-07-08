package book.ch9.fixedthreadpool;

public class Student implements Runnable {

    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name +"开始考试.");
        long start = System.nanoTime();
        int num =  (int)(Math.random()*Integer.MAX_VALUE);
        for(int i=0; i<num; i++);
        long end = System.nanoTime();
        System.out.println(name+"考试完毕,答题用时:"+(end-start)+"纳秒");
    }
}
