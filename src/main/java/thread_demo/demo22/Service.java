package thread_demo.demo22;

public class Service {
    private String usernameParam;

    private String passwordParam;
    //synchronized (anyString1) : 实现同步
    private String anyString1 = new String();

    public void SetUserNamePassword(String username, String password) {
        //synchronized (anyString2) : 不同步，调用SetUserNamePassword分别生成不同的String对象
        String anyString2 = new String();
        try {
            synchronized (anyString1) {
                System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "进入同步块");
                usernameParam = username;
                Thread.sleep(2000);
                passwordParam = password;
                System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
