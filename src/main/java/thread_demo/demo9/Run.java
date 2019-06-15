package thread_demo.demo9;

/**
 *  void interrupt : 中断该线程，线程不会停止运行，为该线程设置一个中断的标记
 *
 *  static boolean interrupted() : 判断当前线程是否已经中断，线程的中断状态将被该方法清除
 *
 *  boolean isInterrupted() : 判断该线程是否已经中断，线程的中断状态不受该方法影响
 */
public class Run {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        mythread.interrupt();
//        System.out.println("是否停止 1 : " + mythread.isInterrupted());
//        System.out.println("是否停止 2 : " + mythread.isInterrupted());
        System.out.println("是否停止 1 : " + Thread.interrupted());
        System.out.println("是否停止 2 : " + Thread.interrupted());
    }
}
