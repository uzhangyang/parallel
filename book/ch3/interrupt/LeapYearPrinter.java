package book.ch3.interrupt;

public class LeapYearPrinter extends Thread {
    public void run(){
        int year = 2000;
        System.out.println("闰年包括:");
        while(true){
            if(year%4==0&&year%100!=0 || year%400==0){
                System.out.println("闰年："+year);
            }
            if(isInterrupted()){
                System.out.println("线程类LeapYearPrinter已经被中断.");
                return;
            }
            year++;
        }
    }

}
