package book.ch4.stampedlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class IntList {
    List<Integer> intList;
    StampedLock sl;

    public IntList() {
        intList = new ArrayList<Integer>();
        sl = new StampedLock();
    }

    public void insert(int num) {
        long stamp = sl.writeLock();
        try {
            intList.add(num);
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    public int get(int i) {
        long stamp = sl.readLock();
        try {
            return intList.get(i);
        } finally {
            sl.unlockRead(stamp);
        }
    }

    public int getOptimistic(int i) {
        long stamp = sl.tryOptimisticRead();
        int temp = intList.get(i);
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                temp = intList.get(i);
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return temp;
    }


    public void fillIfEmpty() {
        long stamp = sl.readLock();
        try {
            while (intList.isEmpty()) {

                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0) {
                    stamp = ws;
                    for (int i = 0; i < 10; i++)
                        intList.add(i);
                    break;
                } else {
                    sl.unlockRead(stamp);
                    sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }

}
