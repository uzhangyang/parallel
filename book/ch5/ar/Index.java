package book.ch5.ar;

import java.util.concurrent.atomic.AtomicReference;

public class Index {

    public static void main(String[] args){
        Resource resource = new Resource();
        AtomicReference<Resource> ar = new AtomicReference<Resource>(resource);
        for(int i=1; i<=5; i++){
            new Player(i, resource, ar).start();
        }
    }

}
