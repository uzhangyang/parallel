package book.ch10.temp3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Zhang Yang
 * Hebei University of Science and Technology
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Document mock = new Document();
        String[][] document = mock.generateDocument(100, 1000, "the");
        DocumentTask task = new DocumentTask(document, 0, 100, "the");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();
        try {
            System.out.println("Main: the word appears " + task.get() + " in the document.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
