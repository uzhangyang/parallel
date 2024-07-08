package book.ch9.fixedthreadpool;

public class Index {

    public static void main(String[] args) {
        int stuNum = 10;
        TestRoom testRoom = new TestRoom();
        for (int i = 0; i < stuNum; i++) {
            Student student = new Student("考生" + (i + 1));
            testRoom.test(student);
        }

        testRoom.endTest();
    }
}
