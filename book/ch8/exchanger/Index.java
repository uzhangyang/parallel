package book.ch8.exchanger;

import java.util.concurrent.Exchanger;

public class Index {
    public static void main(String[] args) {
        DataBuffer fbuf = new DataBuffer();
        fbuf.full();
        DataBuffer ebuf = new DataBuffer();
        ebuf.empty();
        Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
        Thread fillingBuffer = new FillingBuffer(ebuf, exchanger);
        Thread emptyingBuffer = new EmptyingBuffer(fbuf, exchanger);
        fillingBuffer.start();
        emptyingBuffer.start();
    }
}
