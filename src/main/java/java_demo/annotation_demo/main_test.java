package java_demo.annotation_demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class main_test {
    public static void main(String[] args) {
        Record record = new Record();
        Class recordC = record.getClass();

        //构造方法
        handlerConstructor(recordC);

        //成员变量
        handlerField(recordC);

        //方法
        handlerMethod(recordC);
    }

    /**
     * 输出构造方法注解级其参数注解
     * @param recordC
     */
    private static void handlerConstructor(Class recordC) {
        Constructor[] constructors = recordC.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            //获取构造方法的注解
            if (constructor.isAnnotationPresent(Constructor_Annotation.class)){
                Constructor_Annotation ca = (Constructor_Annotation) constructor.getAnnotation(Constructor_Annotation.class);
                System.out.println(ca.value());
            }

            //获取构造方法参数的注解
            //getParameterAnnotations()返回的是一个二维数组，数组中元素为每个参数的annotation信息构成的数组
            // (如果该参数没有annotation，则使用{}占位),数组元素顺序与参数声明顺序保持一致
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                if (parameterAnnotations[j].length == 0){
                    System.out.println("未添加annotation注解的参数");
                } else {
                    for (int k = 0; k < parameterAnnotations[j].length; k++) {
                        Field_Method_Patameter_Annotation pa = (Field_Method_Patameter_Annotation)parameterAnnotations[j][k];
                        System.out.println(pa.descripe());
                        System.out.println(pa.type());
                    }
                }
            }

            System.out.println();
        }
    }

    /**
     * 输出成员变量注解
     * @param recordC
     */
    private static void handlerField(Class recordC) {
        Field[] fields = recordC.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(Field_Method_Patameter_Annotation.class)){
                Field_Method_Patameter_Annotation fa = field.getAnnotation(Field_Method_Patameter_Annotation.class);
                System.out.println(fa.descripe());
                System.out.println(fa.type());
            }

            System.out.println();
        }
    }

    /**
     * 输出方法注解及其参数注解
     * @param recordC
     */
    private static void handlerMethod(Class recordC) {
        Method[] methods = recordC.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            if (method.isAnnotationPresent(Field_Method_Patameter_Annotation.class)){
                Field_Method_Patameter_Annotation ma = method.getAnnotation(Field_Method_Patameter_Annotation.class);
                System.out.println(ma.descripe());
                System.out.println(ma.type());
            }

            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int j = 0; j < parameterAnnotations.length; j++) {
                if (parameterAnnotations[j].length == 0){
                    System.out.println("该参数未设置annotation");
                } else {
                    for (int k = 0; k < parameterAnnotations[j].length; k++) {
                        Field_Method_Patameter_Annotation ma = (Field_Method_Patameter_Annotation) parameterAnnotations[j][k];
                        System.out.println(ma.descripe());
                        System.out.println(ma.type());
                    }
                }
            }

            System.out.println();
        }
    }
}
