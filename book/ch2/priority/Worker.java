package book.ch2.priority;

public class Worker extends Thread {
    private String name;

    public Worker(String name, int priority) {
        this.name = name;
        if (priority > 10 || priority <= 0) {
            System.out.println("���棺���ȼ���ȡֵӦ����1-10֮��");
            this.setPriority(Thread.NORM_PRIORITY);
        } else {
            this.setPriority(priority);
        }
    }

    @Override
    public void run() {
        System.out.println(name + "�����ȼ�Ϊ" + this.getPriority());
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "���ڴ�ӡ" + i);
        }
    }
}
