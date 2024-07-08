package book.ch11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConvertToUppercase {

    public static void main(String[] args) {
        System.out.println("将字符串转换为大写");
        List<String> myList = new ArrayList();
        myList.add("zhang");
        myList.add("yang");
        myList.add("sun");
        myList.parallelStream().map(String::toUpperCase)
                .forEach(System.out::print);
        System.out.println("\n使用流过滤");
        int[] intArray = new int[10];
        for(int i=0; i<10; i++)
            intArray[i] = i;
        IntStream.of(intArray).filter(n -> n % 2 == 0)
                .forEach(System.out::print);
        System.out.println("\n限制流输出的个数：");
        IntStream.of(intArray).limit(10)
                .forEach(System.out::print);
        System.out.println("\n略过3个元素：");
        IntStream.of(intArray).limit(10).skip(3)
                .forEach(System.out::print);
        System.out.println("\n使用流对数据进行排序：");
        int[] unsortedAry = new int[]{5, 7, 3, 9, 1};
        IntStream.of(unsortedAry).sorted()
                .forEach(System.out::print);

    }

}
