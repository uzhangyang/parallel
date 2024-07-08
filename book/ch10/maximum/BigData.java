package book.ch10.maximum;

import java.util.Random;

public class BigData {
    private Integer[] bigData;

    public BigData(int size) {
        bigData = new Integer[size];
        generate(size);
    }

    public Integer[] getBigData() {
        return bigData;
    }

    private void generate(int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            bigData[i] = random.nextInt(size);
        }
    }

}
