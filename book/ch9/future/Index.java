package book.ch9.future;

import java.util.ArrayList;
import java.util.List;

public class Index {

    public static void main(String[] args) {
        int stuNum = 8;
        List<Student> stuList = new ArrayList<Student>();
        TestRoom testRoom = new TestRoom();
        for (int i = 0; i < stuNum; i++) {
            Student student = new Student("考生"+(i+1));
            testRoom.test(student);
            stuList.add(student);
        }
        for(Student stu: stuList){
            System.out.println(stu.getName()+"考试用时为:"
                    + testRoom.getTime(stu) +"纳秒");

        }
        testRoom.endTest();
    }
}
