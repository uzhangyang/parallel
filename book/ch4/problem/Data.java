package book.ch4.problem;

public class Data {
    int a = 0;
    int b = 0;

    public void increase() {
        a++;
        b++;
    }

    public void isEqual() {
        System.out.println("a=" + a + "\tb=" + b + "\t" + (a == b));
    }
}
