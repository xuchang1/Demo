package java_demo.reflecet_demo;

import java.lang.reflect.Constructor;

public class main_demo1 {
    public static void main(String[] args) throws Exception{
        //,class方法获取相应的class对象
        Class<demo1> demo1Class = demo1.class;

        //返回被public修饰的构造方法
//        Constructor<?>[] constructors = demo1Class.getConstructors();
        //根据构造方法的参数类型.class获取相应构造方法
//        Constructor<demo1> constructor = demo1Class.getConstructor(Class<?>... parameterTypes);
        //示例 : demo1Class.getConstructor(String.class, int.class);

        //返回所有构造方法
//        Constructor<?>[] constructors = demo1Class.getDeclaredConstructors();
//        Constructor<demo1> constructor = demo1Class.getDeclaredConstructor(String.class, int.class);

        //按声明顺序返回所有的构造方法(声明顺序与方法在类中的位置顺序相反)
        Constructor<?>[] constructors = demo1Class.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> declaredConstructor = constructors[i];
            constructorPrint(declaredConstructor);

            demo1 demo = null;
            while (demo ==  null) {
                try {
                    if (i == 2) {
                        demo = (demo1) declaredConstructor.newInstance();
                    } else if (i == 1){
                        demo = (demo1) declaredConstructor.newInstance("1", 2);
                    } else if (i == 0){
                        Object[] parameters = new Object[]{new String[]{"1", "2", "3"}};
                        demo = (demo1) declaredConstructor.newInstance(parameters);
                    }
                } catch (Exception e) {
                    System.out.println("在创建对象时抛出异常，将该构造方法设置为允许创建对象");
                    declaredConstructor.setAccessible(true);
                }
            }

            demo.print();
            System.out.println();
        }
    }

    /**
     * 输出是否携带可变参数，参数类型、异常信息类型
     * @param constructor
     */
    private static void constructorPrint(Constructor<?> constructor) {
        System.out.println("查看是否允许携带可变数量的参数 : " + constructor.isVarArgs());
        System.out.println("修饰符 : " + constructor.getModifiers());

        System.out.println("该构造方法的入口参数类型依次为 : ");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int j = 0; j < parameterTypes.length; j++) {
            System.out.println(parameterTypes[j]);
        }

        System.out.println("该构造方法的异常信息类型 : ");
        Class<?>[] exceptionTypes = constructor.getExceptionTypes();
        for (int j = 0; j < exceptionTypes.length; j++) {
            System.out.println(exceptionTypes[j]);
        }
    }
}
