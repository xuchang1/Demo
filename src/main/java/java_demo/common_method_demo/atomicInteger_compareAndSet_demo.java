package java_demo.common_method_demo;

import java.util.concurrent.atomic.AtomicInteger;

public class atomicInteger_compareAndSet_demo {
    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger(0);
        //compareAndSet(int expect, int update) : 如果c的当前值=expect，则以原子的方式将该值设置为update
        System.out.println(c.compareAndSet(0, 6));
        System.out.println(c.get());
    }
}
