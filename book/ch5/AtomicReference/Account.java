package book.ch5.AtomicReference;

public class Account {

    String card_name;
    int money_num;

    public Account(String n, int m) {
        card_name = n;
        money_num = m;
    }

    public int saveMoney(int increament){
        return money_num += increament;
    }

    public String toString() {
        return "账户名：" + card_name + "; 账户余额" + money_num;
    }

}
