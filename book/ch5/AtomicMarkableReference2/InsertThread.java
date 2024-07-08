package book.ch5.AtomicMarkableReference2;

public class InsertThread extends Thread {

    LockFreeLinkedlist<Integer> list;
    int id;

    public InsertThread(LockFreeLinkedlist<Integer> list, int id) {
        this.list = list;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.insert(id * 5000 + i);
        }


    }

}
