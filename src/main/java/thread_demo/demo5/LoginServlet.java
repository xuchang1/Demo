package thread_demo.demo5;

/**
 * 静态变量的线程共享问题
 */
public class LoginServlet {
    private static String usernameRef;

    private static String passwordRef;

    public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;

            System.out.println("username : " + usernameRef + ", password : " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
