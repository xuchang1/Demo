package java_demo.reflecet_demo;

/**
 * 通过反射获取类中方法
 *
 * class对象获取类中方法
 *      1、getMethods() : 获取该类及父类中的public方法
 *      2、getMethod(String name, Class<?>...parameterTypes) : 根据方法名称及参数class类型，获取相应public方法(包括父类中)
 *      3、getDeclaredMethods() : 获取本类中的所有方法
 *      4、getDeclaredMethod(String name, Class<?>...parameterTypes) : 根据方法名称及参数class类型，获取相应public方法
 *
 * Method类方法
 *
 *      1、getName() : 方法名称
 *      2、getParameterTypes() : 以class数组的形式返回参数类型
 *      3、getReturnType() : 以class对象的形式返回返回值类型
 *      4、getExceptionTypes() : 以class数组的形式返回可能抛出异常的类型
 *      5、isVarArgs() : 判断是否携带可变数量的参数
 *      6、getModifiers() ：返回修饰符整数
 *      7、invoke(Object obj,Object...args) : 通过类的对象obj调用该方法，参数为args，返回调用方法的返回值
 */
public class demo3 {
    static void staticMethod(){
        System.out.println("执行 staticMethod方法");
    }

    public int publicMethod(int i) {
        System.out.println("执行 publicMethod方法");
        return i*100;
    }

    protected int protectedMethod(String s, int i) throws NumberFormatException{
        System.out.println("执行 protectedMethod方法");
        return Integer.valueOf(s) + i;
    }

    private String privateMethod(String... strings) {
        System.out.println("执行 privateMethod方法");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
