package thread.demo01;

public class thread01 extends Thread {


    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            System.out.println("我要看代码" + i);
        }
    }


    public static void main(String[] args) {
        thread01 thread01 = new thread01();
        thread01.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我要学习线程" + i);
        }
    }
}
