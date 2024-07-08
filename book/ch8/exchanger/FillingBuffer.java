package book.ch8.exchanger;

import java.util.concurrent.Exchanger;

public class FillingBuffer extends Thread {

    DataBuffer buffer;
    Exchanger<DataBuffer> exchanger;

    public FillingBuffer(DataBuffer buffer, Exchanger<DataBuffer> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    public void run() {

        try {
            while (!buffer.isFull()) {
                if (buffer.isEmpty()) {
                    System.out.println(getName()+"的缓冲已清空，开始放入");
                }
                buffer.add();
                if (buffer.isFull()) {
                    System.out.println(getName()+"的缓冲区已满，等待交换数据");
                    buffer = exchanger.exchange(buffer);
                    System.out.println(getName()+"数据交换完成");
                }

            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
