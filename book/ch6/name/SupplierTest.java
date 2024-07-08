package book.ch6.name;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args){
        int[] numbers={1,2,3,4,5,6,7,8,10,9};
        int nmax = getMax(()->{
            int maxVal= numbers[0];
            for(int number: numbers){
               if(maxVal < number)
                   maxVal=number;
            }
            return maxVal;
        });
        System.out.println(nmax);
    }

    public static Integer getMax(Supplier<Integer> is){
        return is.get();
    }
}
