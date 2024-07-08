package book.ch10.sort;

public class Data {
    private int[] bigData;

    Data() {

    }

    public void generate(int size) {
        bigData = new int[size];
        for (int i = 0; i < size; i++) {
            bigData[i] = (int) Math.random() * size;
        }
    }

    public int[] getBigData() {
        return bigData;
    }

    public boolean check() {
        for (int i = 0; i < bigData.length - 1; i++) {
            if (bigData[i] > bigData[i + 1])
                return false;
        }
        return true;
    }
}
