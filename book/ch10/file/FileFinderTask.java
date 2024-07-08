package book.ch10.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FileFinderTask extends RecursiveTask<String> {

    private static final long serialVersionUID = 1L;
    private String path;
    private String fileName;
    private TaskCanceller tc;

    public FileFinderTask(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
        tc = new TaskCanceller();
    }

    @Override
    protected String compute() {
        List<String> results = new ArrayList<String>();
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File fileTemp : files) {
                if (fileTemp.isDirectory()) {
                    FileFinderTask task = new FileFinderTask(fileTemp.getAbsolutePath(), fileName);
                    tc.addToTaskList(task);
                    task.fork();
                } else {
                    if (fileTemp.getName().equals(fileName)) {
                        System.out.println("文件'" + fileName + "'在" + path+"文件夹下被找到");
                        tc.cancelTasks(this);
                        return path;
                    }
                }
            }
        }
        for (FileFinderTask task : tc.getTaskList()) {
            results.add(task.join());
        }
        for (String str : results)
            if (str != null)
                return str;
        return null;
    }

    public void printCancelMessage() {
        System.out.println("搜索文件夹" +path+ "的任务正在尝试被取消." );
    }

}
