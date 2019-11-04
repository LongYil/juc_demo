package longdatech.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {

    public static void main(String[] args){

        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++){
            new Thread(()->{
                int expectedValue = cas.get();
                boolean b = cas.compareAndSet(expectedValue,(int) (Math.random() * 101));
                System.out.println(b);
            }).start();
        }

        AtomicInteger atomicInteger = new AtomicInteger();

        atomicInteger.getAndIncrement();


    }

}

class CompareAndSwap{
    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = value;
        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,int newVValue){
        return expectedValue == compareAndSwap(expectedValue,newVValue);
    }
}
