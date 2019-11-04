package longdatech.juc;

public class TestThread {
    public static void main(String[] args){
        new Thread(()->{
            System.out.println("Hello,World!");
        }).start();
    }
}
