package book.ch5.ar;

import java.util.concurrent.atomic.AtomicReference;

public class Player extends Thread{

    int id;
    Resource resource;
    AtomicReference<Resource> ar;

    public Player(int id, Resource r, AtomicReference<Resource> ar){
        this.id = id;
        resource = r;
        this.ar = ar;
    }

    public void run(){
        if(ar.compareAndSet(resource, new Resource(this.getName())))
            System.out.println(this.id + "号选手抢到了答题");
        else
            System.out.println(this.id + "号选手没抢到");
    }

}
