package java_demo.annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//用于变量、方法、参数
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
//运行时加载Annotation到JVM中
@Retention(RetentionPolicy.RUNTIME)
public @interface Field_Method_Patameter_Annotation {
    //定义一个没有默认值的String类型成员
    String descripe();

    //定义一个默认值为void.class的Class类型成员
    Class type() default void.class;
}
