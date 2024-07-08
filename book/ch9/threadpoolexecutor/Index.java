package book.ch9.threadpoolexecutor;

public class Index {
    public static void main(String[] args) {
        int workerNum = 5;
        Employer employer = new Employer();
        for (int i = 0; i < workerNum; i++) {
            Worker worker = new Worker("����" + (i + 1));
            employer.dispatch(worker);
        }
        employer.endWork();
    }
}
