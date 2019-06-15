package thread_demo.demo4;

/**
 * 基本数据类型i并不能被共享，3个线程中的i指向不同的地址，参考基本数据类型在堆中的初始化
 */
public class Analy {
    public static void main(String[] args) {
        int i = 100;
        new OwnThread(i).start();    //新建线程，并启动
        new OwnThread(i).start();    //新建线程，并启动

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程中i的值变为了：" + i);
    }
}

class OwnThread extends Thread {

    int id;
    int sno;    //申明int变量。因为系统默认初始化为0，所以应该是定义一个int变量

    OwnThread(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this) {
                sno = id;    //保存id.i的数值，到线程私有变量sno
                id++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(this.getName() + "," + sno);
        }
    }
}