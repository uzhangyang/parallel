package book.ch7.singlepc;

class Producer extends Thread {
    private CubbyHole cubbyHole;

    public Producer(CubbyHole c) {
        cubbyHole = c;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            cubbyHole.put((int) (100 * Math.random()));
        }
    }
}
