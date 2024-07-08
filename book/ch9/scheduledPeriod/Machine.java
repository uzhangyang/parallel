package book.ch9.scheduledPeriod;

public class Machine implements Runnable {
    int temperature;

    Machine(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void run() {
        perform();
        temperature++;
        System.out.println("机器的工作温度在升高,当前温度:" + temperature);
    }

    private void perform() {
        int temp = (int) (Math.random() * Integer.MAX_VALUE);
        int sum = 0;
        for (int i = 0; i < temp; i++)
            sum += i;
    }

    public int getTemperature() {
        return temperature;
    }

}
