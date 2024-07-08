package book.ch7.condition;

public class Index {

    private static int np = 4;
    private static int nc = 4;
    public static int nbuf = 10;

    public static void main(String[] args) {
        CubbyHole c = new CubbyHole(nbuf);
        Producer[] producer = new Producer[np];
        for (int i = 0; i < np; i++) {
            producer[i] = new Producer(c, i + 1);
            producer[i].start();
        }

        Consumer[] consumer = new Consumer[nc];
        for (int i = 0; i < nc; i++) {
            consumer[i] = new Consumer(c, i + 1);
            consumer[i].start();
        }

        try {
            for (int i = 0; i < np; i++) {
                producer[i].join();
            }
            for (int i = 0; i < nc; i++) {
                consumer[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
