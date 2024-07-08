package book.ch3.bucketsort;

import java.util.ArrayList;
import java.util.Collections;

public class Worker implements Runnable {

    ArrayList<Integer> bucket;

    public Worker(ArrayList<Integer> bucket){
        this.bucket = bucket;
    }

    @Override
    public void run() {
        Collections.sort(bucket);
    }
}
