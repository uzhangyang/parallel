package book.ch7.singlepc;

class Consumer extends Thread {
    private CubbyHole cubbyHole;

    public Consumer(CubbyHole c) {
        cubbyHole = c;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            cubbyHole.get();
        }
    }
}

