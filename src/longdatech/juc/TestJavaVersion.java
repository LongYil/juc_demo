package longdatech.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestJavaVersion {
    public static void main(String[] args){
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);
        Map<Object,Object> map = new ConcurrentHashMap<>();

        map.put(1,1);

    }
}
