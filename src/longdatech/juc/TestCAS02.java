package longdatech.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS02 {

    public static void main(String[] args) throws Exception{


        Unsafe unsafe = Unsafe.getUnsafe();
        long valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));;


//        for (int i = 0; i < 10; i++){
//
//            AtomicInteger atomicInteger = new AtomicInteger(500);
//
//            Field[] fields = atomicInteger.getClass().getDeclaredFields();
//
//            for (Field field : fields){
//                String str = field.getName();
//                try {
//                    field.setAccessible(true);
//                    Object obj = field.get(atomicInteger);
//                    System.out.println(str + ":" + obj);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

    }
}
