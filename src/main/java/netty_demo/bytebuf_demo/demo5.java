package netty_demo.bytebuf_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import org.junit.jupiter.api.Test;

public class demo5 {
    @Test
    public void test1() {
        PooledByteBufAllocator pooledByteBufAllocator = new PooledByteBufAllocator();
        ByteBuf byteBuf = pooledByteBufAllocator.buffer();
    }
}
