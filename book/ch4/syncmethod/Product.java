package book.ch4.syncmethod;

public class Product {

    String name;
    int numbers;

    Product(String name, int numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public synchronized void increase(int newNum) {
        numbers += newNum;
    }

    public synchronized void decrease(int newNum) {
        numbers -= newNum;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

}
