package book.ch5.AtomicMarkableReference2;

public class DeleteThread extends Thread {

    LockFreeLinkedlist<Integer> list;
    int id;

    public DeleteThread(LockFreeLinkedlist<Integer> list, int id) {
        this.list = list;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.remove(id * 5000 + i);
        }
    }

}
