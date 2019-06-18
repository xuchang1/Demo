package thread_demo.demo26;

/**
 * synchronized同步监视String字符串时，注意String常量池缓存功能（a == b）
 */
public class Run {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();
    }
}
