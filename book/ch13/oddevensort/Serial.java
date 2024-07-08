package book.ch13.oddevensort;

public class Serial {
    //数据量大小
    public static final int N = 100000;
    //生成数据
    public static int[] generate_data() {
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = (int) (Math.random() * N);
        }
        return data;
    }
    //奇偶排序算法
    public static void sort(int[] data) {
        int temp;
        for (int phase = 0; phase < N; phase++) {
            if (phase % 2 == 0) {  //偶阶段
                for (int i = 1; i < N; i += 2) {
                    if (data[i - 1] > data[i]) {
                        temp = data[i];
                        data[i] = data[i - 1];
                        data[i - 1] = temp;
                    }
                }
            } else {  //奇阶段
                for (int i = 1; i < N - 1; i += 2) {
                    if (data[i] > data[i + 1]) {
                        temp = data[i];
                        data[i] = data[i + 1];
                        data[i + 1] = temp;
                    }
                }
            }
        }
    }

//    public static void sort(int[] data) {
//        int temp;
//        for (int phase = 0; phase < N; phase++) {
//            if (phase % 2 == 0) {  //偶阶段
//                for (int i = 0; i < N - 1; i += 2) {
//                    if (data[i] > data[i + 1]) {
//                        temp = data[i];
//                        data[i] = data[i + 1];
//                        data[i + 1] = temp;
//                    }
//                }
//            } else {  //奇阶段
//                for (int i = 1; i < N - 1; i += 2) {
//                    if (data[i] > data[i + 1]) {
//                        temp = data[i];
//                        data[i] = data[i + 1];
//                        data[i + 1] = temp;
//                    }
//                }
//            }
//        }
//    }

//    public static void sort(int[] data) {
//        int temp, start_index;
//        for (int phase = 0; phase < N; phase++) {
//            start_index = phase % 2 == 0? 0 : 1;
//            for (int i = start_index; i < N - 1; i += 2) {
//                if (data[i] > data[i + 1]) {
//                    temp = data[i];
//                    data[i] = data[i + 1];
//                    data[i + 1] = temp;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println("生成" + N + "个数据中...");
        int[] data = generate_data();

        long start = System.currentTimeMillis();
        sort(data);
        long end = System.currentTimeMillis();
        System.out.print(N + "个数据排序需要" + (end - start) + "毫秒");

        for (int i = 0; i < N - 1; i++)
            if (data[i] > data[i + 1])
                System.out.println("验证失败");
    }
}
