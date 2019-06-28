package thread_demo.demo29;

/**
 * 使用volatile修饰变量，保证变量多线程之间的可见性
 * 强制从公共堆栈中取得变量的值，而不是从线程私有栈中取得变量的值。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        Thread thread = new Thread(printString);
        thread.start();

        Thread.sleep(10000);
        System.out.println("停止循环");
        printString.setFlag(false);
    }
}
