package book.ch10.file;

import java.util.ArrayList;
import java.util.List;

public class TaskCanceller {
    private List<FileFinderTask> tc;

    public TaskCanceller() {
        tc = new ArrayList<FileFinderTask>();
    }

    public void addToTaskList(FileFinderTask task) {
        tc.add(task);
    }

    public List<FileFinderTask> getTaskList() {
        return tc;
    }

    public void cancelTasks(FileFinderTask cancelledTask) {
        for (FileFinderTask task : tc) {
            if (task != cancelledTask) {
                task.cancel(true);
                task.printCancelMessage();
            }
        }
    }
}
