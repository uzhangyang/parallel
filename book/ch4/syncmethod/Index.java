package book.ch4.syncmethod;

public class Index {

    public static void main(String[] args) {
        Product product = new Product("pen", 1000);
        Worker worker1 = new Worker(product);
        Worker worker2 = new Worker(product);
        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The number of pens is " + product.getNumbers());
    }

}
