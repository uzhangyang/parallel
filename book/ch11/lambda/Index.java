package book.ch11.lambda;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class Index {
    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("zhao","qian","sun","li","zhang","wang");
        System.out.println("以z开头的字符串：");
        //对find方法进行调用，这里使用了Lambda表达式作为参数。
        find(list, (String str)->str.startsWith("z"));
    }
    // find方法的定义，其中第二个参数为Predicate类型，我们调用p的test方法进行过滤。
    public static void find(List<String> list, Predicate<String> p){
        for(String name : list){
            if(p.test(name)){
                System.out.println(name);
            }
        }
    }
}
