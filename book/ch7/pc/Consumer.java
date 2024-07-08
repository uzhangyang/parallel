package book.ch7.pc;

class Consumer extends Thread {
    private CubbyHole cubbyHole;
    private int id;

    public Consumer(CubbyHole c, int id) {
        cubbyHole = c;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            cubbyHole.get(id);
        }
    }
}

