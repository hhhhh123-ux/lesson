package thread.demo01;

public class thread03 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我要看代码" + i);
        }
    }


    public static void main(String[] args) {
        //
        thread03 thread03=new thread03();
        Thread thread=new Thread(thread03);
        thread.start();

        new Thread(thread03).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我要学习线程" + i);
        }
    }
}
