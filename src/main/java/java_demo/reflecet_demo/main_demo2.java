package java_demo.reflecet_demo;

import java.lang.reflect.Field;

public class main_demo2 {
    public static void main(String[] args) throws Exception {
        demo2 demo2 = new demo2(1, 1.2f, true, "abd");
        Class demo2Class = demo2.getClass();

        Field[] fields = demo2Class.getDeclaredFields();
//        Field field = demo2Class.getField("s2");
//        filedPrient(demo2, field);
//        Field[] fields = demo2Class.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            filedPrient(demo2, field);
        }
    }

    private static void filedPrient(demo2 demo2, Field field) {
        System.out.println("名称为 : " + field.getName());
        Class type = field.getType();
        System.out.println("类型为 : " + type);
        System.out.println("修饰符 : " + field.getModifiers());

        while (true) {
            try {
                if (type.equals(int.class)) {
                    System.out.println("初始值为 : " + field.getInt(demo2));
                    field.setInt(demo2, 2);
                    System.out.println("改变后值为 : " + field.getInt(demo2));
                } else if (type.equals(float.class)) {
                    System.out.println("初始值为 : " + field.getFloat(demo2));
                    field.setFloat(demo2, 2.2f);
                    System.out.println("改变后值为 : " + field.getFloat(demo2));
                } else if (type.equals(boolean.class)) {
                    System.out.println("初始值为 : " + field.getBoolean(demo2));
                    field.setBoolean(demo2, false);
                    System.out.println("改变后值为 : " + field.getBoolean(demo2));
                } else if (type.equals(String.class)) {
                    System.out.println("初始的值为 : " + field.get(demo2));
                    field.set(demo2, "efg");
                    System.out.println("改变后的值为 : " + field.get(demo2));
                }
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("在操作成员变量 " + type + "时出现异常，setAccessible为true");
                field.setAccessible(true);
            }
        }
    }
}
