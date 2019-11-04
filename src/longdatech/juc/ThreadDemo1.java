package longdatech.juc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreadDemo1 {

    public static void main(String[] args){
        final Object o = new Object();
        final Thread t = new Thread(()->{
            System.out.println("hello,world");
        });

        Set<String> state = new HashSet();

        Thread t2 = new Thread(()->{

            while (true){
                String st = t.getState().name();
                state.add(st);
            }

        });

        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(4000);
            state.forEach(item->{
                System.out.println("状态:" + item);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> list = new LinkedList<>();


    }
}
