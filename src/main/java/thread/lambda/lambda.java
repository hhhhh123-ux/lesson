package thread.lambda;

public class lambda {

    static class like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda2" );
        }
    }

    public static void main(String[] args) {
        ILike like=new like();
        like.lambda();
        like=new like2();
        like.lambda();
        class like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3" );
            }
        }

        like=new like3();
        like.lambda();


        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        like=()->{
         System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

interface ILike{
   void lambda();
}

class like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda" );
    }
}