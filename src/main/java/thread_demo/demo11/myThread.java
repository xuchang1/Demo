package thread_demo.demo11;

/**
 *static void yield() : 当前线程放弃cpu资源，变为就绪状态，重新等待获取cpu时间片
 */
public class myThread extends Thread {
    @Override
    public void run() {
        int count = 0;
        long beginTime = System.currentTimeMillis();

        for (int i = 0; i < 5000000; i++) {
//            Thread.yield();
            count += count;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("计算用时 : " + (endTime - beginTime) + "毫秒");
    }
}
