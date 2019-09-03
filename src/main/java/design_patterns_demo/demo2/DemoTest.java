package design_patterns_demo.demo2;

/**
 * JDK的动态的代理 :
 *      1、
 */
public class DemoTest {
    public static void main(String[] args) {
        Man man = new Man();
        System.out.println(man.getClass());
        Person proxy = (Person) new ManProxy(man).getProxyInstance();
        System.out.println(proxy.getClass());
        String s = proxy.say("abc");
        System.out.println(s);
//        proxy.call();
    }
}
