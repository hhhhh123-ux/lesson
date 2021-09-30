package syn;

import lombok.SneakyThrows;

//
public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account("结婚", 1000);
        Drawing you = new Drawing(account, 50, "你");
        Drawing girl = new Drawing(account, 100, "girl");
        you.start();
        girl.start();
    }
}

//账号
class Account {

    public String name;
    public int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

}

class Drawing extends Thread {
    Account account;

    int drawingMoney;

    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @SneakyThrows
    @Override
    public void run() {
        //锁增删改
        synchronized (account) {
            //钱不够
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够");
                return;
            }

            Thread.sleep(100);
            account.money = account.money - drawingMoney;
            nowMoney = drawingMoney + nowMoney;
            System.out.println(account.name + "余额为:" + account.money);
            System.out.println(this.getName() + "手里的钱" + nowMoney);

        }
    }
}
