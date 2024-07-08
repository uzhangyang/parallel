package book.ch8.exchanger;

import java.util.LinkedList;

public class DataBuffer {
    LinkedList<Integer> buffer;

    DataBuffer() {
        buffer = new LinkedList<Integer>();
    }

    public void full() {
        while (!isFull()) {
            add();
        }
    }

    public void empty() {
        while (!isEmpty()) {
            take();
        }
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean isFull() {
        if (buffer.size() >= 100) {
            return true;
        } else {
            return false;
        }
    }

    public void add() {
        buffer.addLast((int) (Math.random() * 100));
    }

    public void take() {
        buffer.removeFirst();
    }
}
