package queue;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TestLinkedQueue {

    public static void main(String[] args){

        DoWork doWork = new DoWork();

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++){
            service.submit(()->{
                doWork.add();
            });
        }

        service.shutdown();
    }

}

class DoWork{
    ReentrantLock lock = new ReentrantLock();

    public void check(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "检查空间");
    }

    public void add(){
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "准备添加数据");
        check();
        lock.unlock();
        lock.unlock();
    }

}