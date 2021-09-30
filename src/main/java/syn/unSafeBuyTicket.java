package syn;

//不安全买票
public class unSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "1").start();
        new Thread(buyTicket, "2").start();
        new Thread(buyTicket, "3").start();
    }
}


class BuyTicket implements Runnable {
    int ticketNum = 10;
    boolean flag = true;

    @Override
    public void run() {
        //
        while(flag){
            try {
                buy();
            }catch (Exception e){
            }
        }

    }

    //synchronized
    public synchronized void buy() {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNum--);
    }
}



