package DeadLock;

public class DeadLock {
    public static void main(String[] args) {

        MakeUp makeUp=new MakeUp(0,"1");
        MakeUp makeUp1=new MakeUp(1,"2");
        makeUp.start();
        makeUp1.start();
    }
}

class lipstick{

}

class mirror{

}


class MakeUp  extends Thread{

    static lipstick lipstick=new lipstick();
    static mirror mirror=new mirror();

    int choice; //选择
    String name;

    public MakeUp(int choice,String name){
        this.choice=choice;
        this.name=name;
    }



    @Override
    public void run(){

        makeUp();
    }


    private void makeUp() {
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.name+"获取口红的锁");
            }
            synchronized (mirror){
                System.out.println(this.name+"获取镜子的锁");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.name+"获取镜子的锁");
            }
            synchronized (lipstick){
                System.out.println(this.name+"获取口红的锁");
            }
        }


    }
}
