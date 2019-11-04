package longdatech.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCAS01 {

    public static void main(String[] args){

        ExecutorService service = Executors.newFixedThreadPool(10);
        Lock lock = new ReentrantLock();
        Runnable task =  new Runnable() {
            public AtomicInteger a = new AtomicInteger(0);
            @Override
            public void run() {
//                lock.lock();
                for (int i = 0; i < 100000; i++){
                    a.getAndIncrement();
                }
//                lock.unlock();
                System.out.println("当前线程 " + Thread.currentThread().getName() +":" + a);
            }
        };

        for (int i = 0; i < 10; i++){
            service.submit(task);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}


