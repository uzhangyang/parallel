package book.ch4.syncmethod;

public class Worker implements Runnable {

    Product product;

    Worker(Product product) {
        this.product = product;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i <= 50) {
                product.increase(100);
            } else {
                product.decrease(100);
            }
            if (i == 50) {
                System.out.println("When " + Thread.currentThread().getName() + " executes i=50, the number of pens is " + product.getNumbers());
            }
        }
    }
}
