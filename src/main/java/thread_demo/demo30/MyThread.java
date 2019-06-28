package thread_demo.demo30;

public class MyThread extends Thread {

        //static修饰的变量是类变量，被该类的所有实例对象共享
//    public volatile int count;
    public volatile static  int count;

//    public static Object  object = new Object();

    private void addCount() {
        for (int i = 0; i < 100; i++) {
            /*synchronized (object) {
                count++;
            }*/

            count++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
