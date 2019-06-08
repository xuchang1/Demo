package java_demo.reflecet_demo;

import java.lang.reflect.Method;

public class main_demo3 {
    public static void main(String[] args) {
        demo3 demo3 = new demo3();
        Class demo3Class = demo3.getClass();

        Method[] declaredMethods = demo3Class.getDeclaredMethods();

        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            String name = method.getName();
            System.out.println("方法name : " + name);
            System.out.println("方法参数类型 : " );
            Class[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(parameterTypes[j]);
            }
            System.out.println("方法返回值类型 : " + method.getReturnType());
            System.out.println("方法抛出异常类型 : ");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(exceptionTypes[j]);
            }
            System.out.println("方法是否携带可变数量的参数 : " + method.isVarArgs());
            System.out.println("方法的修饰符 : " + method.getModifiers());

            while (true) {
                try {
                    if (name.equals("staticMethod")){
                        System.out.println(method.invoke(demo3));
                    } else if (name.equals("publicMethod")){
                        System.out.println(method.invoke(demo3, 1));
                    } else if (name.equals("protectedMethod")){
                        System.out.println(method.invoke(demo3, "2", 3));
                    } else if (name.equals("privateMethod")){
                        Object[] parameters = {new String[]{"M", "W", "Q"}};
                        System.out.println(method.invoke(demo3, parameters));
                    }
                    System.out.println();
                    break;
                } catch (Exception e) {
                    System.out.println("设置setAccessible为true");
                    method.setAccessible(true);
                }
            }
        }
    }
}
