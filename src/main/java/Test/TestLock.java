package Test;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{

    int TicketNum=10;


    private static ReentrantLock lock=new ReentrantLock();


    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(TicketNum>0){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(TicketNum--);
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }

        }

    }
}
