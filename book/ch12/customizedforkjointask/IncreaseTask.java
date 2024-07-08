package book.ch12.customizedforkjointask;

public class IncreaseTask extends CustomizedRecursiveAction {

    private static final long serialVersionUID = 1L;
    int[] array;
    int start;
    int end;

    IncreaseTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= 500000) {
            sequentialCompute();
        } else {
            IncreaseTask task1 = new IncreaseTask(array, start, end / 2);
            IncreaseTask task2 = new IncreaseTask(array, end / 2, end);
            invokeAll(task1, task2);
        }
    }

    private void sequentialCompute() {
        for (int i = start; i < end; i++) {
            array[i]++;
        }
    }

}
