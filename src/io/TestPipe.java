package io;


import java.io.*;

public class TestPipe {

    public static void main(String[] args) throws Exception{

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        inputStream.connect(outputStream);


        OutputStream out = new FileOutputStream("E://destination.txt");

        out.write("哈哈哈".getBytes());

        out.close();
        Thread.sleep(1000);

        InputStream in = new FileInputStream("E://destination.txt");

        byte[] bytes = new byte[1024];

        System.out.println(new String());
        int a = in.read();
        int i = 0;
        while (a != -1){
            bytes[i] = (byte) a;
            a = in.read();
            i++;
        }

        System.out.println(new String(bytes));

    }


}
