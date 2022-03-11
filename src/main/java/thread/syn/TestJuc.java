package thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJuc {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
    }
}
