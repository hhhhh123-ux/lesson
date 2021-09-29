package lambda;

public class lambda2 {




    public static void main(String[] args) {

        ILove love=null;


//
//       ILove love=(int a)->{
//            System.out.println("I love you->"+a);
//        };
//
//
//         love=(a)->{
//            System.out.println("I love you->"+a);
//        };


//        love=a->{
//            System.out.println("I love you->"+a);
//        };

        love=a->System.out.println("I love you->"+a);
        love.love(2);



    }
}

interface ILove{
    void love(int a);
}


