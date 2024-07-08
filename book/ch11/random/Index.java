package book.ch11.random;

public class Index {
    public static void main(String[] args) {
        int N = 4;
        Thread[] threads = new Thread[N];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Generator();
            threads[i].start();
        }
    }
}
