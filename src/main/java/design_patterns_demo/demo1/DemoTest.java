package design_patterns_demo.demo1;

/**
 * 代理模式 : 通过代理对象访问目标对象。可以在目标对象实现的基础上，实现功能的扩展而不用修改目标对象代码。
 * 静态代理 :
 *      1、代理对象和被代理对象必须实现同一接口或者继承同一个父类，
 *      2、代理对象中引用接口或者父类对象，重写的父类同名方法中通过引用的对象调用父类方法，在方法调用前后增加额外功能，实现对象功能的扩展。
 */
public class DemoTest {
    public static void main(String[] args) {
        ManProxy manProxy = new ManProxy(new Man());
        manProxy.say();
        manProxy.call();
    }
}
