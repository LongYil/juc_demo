package exception;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 8个基本数据类型，引用数据类型，String与Integer，封装、继承、多态
 * 内部类，接口，枚举，抽象类，抽象方法，覆写，重载
 * 集合框架，HashMap，TreeMap,HashTable，ConCurrentHashMap，Set，ArrayList...
 * IO/NIO，多线程，线程池，锁，AQS，CAS，网络编程，Socket，反射，异常，java8新特性
 */

public class TestException {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, i);
            Date tempDate = calendar.getTime();
            String str = dateToStr(tempDate);
            switch (i){
                case 0:
                    str = str + "(星期一)";
                    break;
                case 1:
                    str = str + "(星期二)";
                    break;
                case 2:
                    str = str + "(星期三)";
                    break;
                case 3:
                    str = str + "(星期四)";
                    break;
                case 4:
                    str = str + "(星期五)";
                    break;
            }
            list.add(str);
        }

        list.forEach(item->{
            System.out.println(item);
        });

        VirtualMachineError error;

        ArithmeticException arithmeticException;

        RuntimeException runtimeException;

        IOException exception;

    }

    public static String dateToStr(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

}
