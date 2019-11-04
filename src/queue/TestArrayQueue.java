package queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestArrayQueue {

    public static void main(String[] args) throws Exception{

        Queue queue = new ArrayBlockingQueue(10000000);

        final CountDownLatch latch = new CountDownLatch(2);

        Runnable task1 = ()->{
            for (int i = 0; i < 5000000; i++){
                queue.add("a:" + i);
            }
            latch.countDown();
        };

        Runnable task2 = ()->{
            for (int i = 0; i < 5000000; i++){
                queue.add("b:" + i);
            }
            latch.countDown();
        };

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.submit(task1);
        service.submit(task2);

        latch.await();

        System.out.println("队列长度：" + queue.size());

        service.shutdown();
    }


}
