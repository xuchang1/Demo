import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

public class demo2 {

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
    public void test3() {
        System.out.println(SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
    }
}
