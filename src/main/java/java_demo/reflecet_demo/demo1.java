package java_demo.reflecet_demo;

/**
 * 通过反射获取构造方法，测试Constructor相关方法
 *
 * class获取构造方法
 *
 *         1、返回被public修饰的构造方法(返回顺序与方法在类中的顺序相反)
 *         Constructor<?>[] constructors = demo1Class.getConstructors();
 *         2、根据构造方法的参数类型.class获取相应构造方法
 *         Constructor<demo1> constructor = demo1Class.getConstructor(Class<?>... parameterTypes);
 *         示例 : demo1Class.getConstructor(String.class, int.class);
 *
 *         返回所有构造方法(包括private)
 *         3、Constructor<?>[] constructors = demo1Class.getDeclaredConstructors();
 *         4、Constructor<demo1> constructor = demo1Class.getDeclaredConstructor(String.class, int.class);
 *
 * Constructor类的方法
 *         1、isVarArgs() : 是否携带可变数量的参数
 *         2、getParameterTypes() : 以class数组的形式，返回该构造方法参数的类型
 *         3、getExceptionTypes() ：以class数组的形式，返回该构造方法异常的类型
 *         4、newInstance(Object... initargs) : 根据输入的参数，实例化该类的一个对象(没输入参数则调用无参构造方法)
 *         5、setAccessible(boolean flag) : private修饰的构造方法调用newInstance实例化对象时报错，必须先setAccessible(true)，再创建对象
 *         6、getModifiers() : 获得该构造方法修饰符的整数
 */
public class demo1 {

    String s;

    int i, i2, i3;

    private demo1() {
    }

    private demo1(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public demo1(String... strings) {
        if (strings.length > 0 )
            i = Integer.valueOf(strings[0]);
        if (strings.length > 1)
            i2 = Integer.valueOf(strings[1]);
        if (strings.length > 2)
            i3 = Integer.valueOf(strings[2]);
    }

    public void print() {
        System.out.println("s : " + s);
        System.out.println("i : " + i);
        System.out.println("i2 : " + i2);
        System.out.println("i3 : " + i3);
    }
}
