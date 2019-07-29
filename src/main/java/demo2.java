import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import org.junit.jupiter.api.Test;
import thread_demo.demo20.Task;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class demo2 {
    public boolean flag = true;

    public static int x = 0, y = 0;

    @Test
    public void test1() {
        int a = 11111;
        byte[] bytes = (a + "").getBytes();
        System.out.println(bytes.length);
    }

    //基本数据类型与字符串的不同
    //int、long等类型数据，转化为2进制
    //char、String类型，可以通过String 的getBytes()方法转化为字节数组，再通过new String()方法将其转换回来，其他基本数据类型无法使用此方法。
    //getBytes()、new String底层都有默认的编码，设置其他编码时，要保持编解码的一致，不然会乱码。
    @Test
    public void test2() {
        byte a = (byte) 12123131;
        System.out.println(a);
    }

    @Test
    public void test3() throws InterruptedException {
        (new Thread() {
            @Override
            public void run() {
                System.out.println("线程1执行 : ");
                while (flag) {}
                System.out.println("线程1执行结束");
            }
        }).start();

        Thread.sleep(2000);

//        flag = false;
        (new Thread() {
            @Override
            public void run() {
                System.out.println("线程2执行 : ");
                flag = false;
                System.out.println("线程2执行结束");
            }
        }).start();
    }

    @Test
    public void test4() throws InterruptedException {
        final HashMap<String, Integer> map = new HashMap<>();

        while (true) {

            x = 0;
            y = 0;

            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    int a = x;
                    y = 1;
                    map.put("a", a);
                }
            };

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    int b = y;
                    x = 1;
                    map.put("b", b);
                }
            };

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            if (map.get("a") == 1 && map.get("b") == 1) {
                System.out.println("a和b都为1");
            }

//            System.out.println("a : " + map.get("a") + ", b : " + map.get("b"));
            map.clear();
        }
    }
}
