package niodemo.nio_bytebufffer_test;

import java.nio.IntBuffer;

//Buffer的三个属性 position, limit, capacity
//通过多次flip()方法调用，导致limit越来越小，可读写的缓存区域也越来越小，需要调用clear()方法重置该三个属性
//
public class PropertyTest {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(20);

        // 0,20,20
        System.out.println("-------------------------------------------------");
        System.out.println("当前position : " + buffer.position() + ", 当前limit : " + buffer.limit() + ", 当前capacity ： " + buffer.capacity());

        for (int i = 0; i < 10; i++) {
            buffer.put(1);
        }

        //10,20,20
        System.out.println("-------------------------------------------------");
        System.out.println("当前position : " + buffer.position() + ", 当前limit : " + buffer.limit() + ", 当前capacity ： " + buffer.capacity());

        buffer.flip();

        //0,10,20
        System.out.println("-------------------------------------------------");
        System.out.println("当前position : " + buffer.position() + ", 当前limit : " + buffer.limit() + ", 当前capacity ： " + buffer.capacity());

        for (int i = 0; i < 2; i++) {
            buffer.get();
        }

        //2,10,20
        System.out.println("-------------------------------------------------");
        System.out.println("当前position : " + buffer.position() + ", 当前limit : " + buffer.limit() + ", 当前capacity ： " + buffer.capacity());

        buffer.flip();

        //0,2,20
        System.out.println("-------------------------------------------------");
        System.out.println("当前position : " + buffer.position() + ", 当前limit : " + buffer.limit() + ", 当前capacity ： " + buffer.capacity());
    }
}
