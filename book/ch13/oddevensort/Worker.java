package book.ch13.oddevensort;

import java.util.Arrays;

public class Worker extends Thread{

    int[] data;


    public Worker(int[] data){
        this.data = data;

    }

    public void run(){
        Arrays.sort(data);
    }

}
