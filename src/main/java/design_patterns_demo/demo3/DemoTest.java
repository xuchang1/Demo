package design_patterns_demo.demo3;

public class DemoTest {
    public static void main(String[] args) {
        Man man = new Man();
        Man proxy = (Man) new ProxyFactory(man).getProxyInstance();
        proxy.say();
    }
}
