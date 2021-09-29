package demo01;

public class thread04 implements Runnable {

    int totalNum = 10;

    @Override
    public void run() {
        while (true) {
            if (totalNum <= 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到票" + totalNum--);
        }
    }

    public static void main(String[] args) {
       thread04 thread04=new thread04();
        new Thread(thread04,"小名").start();
        new Thread(thread04,"小1").start();
        new Thread(thread04,"小2").start();
    }


}
