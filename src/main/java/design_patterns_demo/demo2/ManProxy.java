package design_patterns_demo.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ManProxy {
    private Object target;

    public ManProxy(Object person) {
        this.target = person;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //proxy : 代理对象
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("传入的 : " + proxy.getClass());
                        System.out.println("代理执行之前");
                        //当代理对象执行某一方法时，InvocationHandler的invoke方法将被执行，该步骤时会通过传入的目标对象执行相应方法
                        //args是方法参数
                        Object returnValue = method.invoke(target, args);
                        System.out.println("代理执行完成");
                        System.out.println("returnValue : " + returnValue);
                        return  returnValue;
                    }
                });
    }
}
/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
/*
public class ProxyFactory{

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }
}*/
