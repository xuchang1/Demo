package java_demo.annotation_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//用于构造方法
@Target(ElementType.CONSTRUCTOR)
//在运行时加载Annotation到JVM中
@Retention(RetentionPolicy.RUNTIME)
public @interface Constructor_Annotation {
    //定义一个有默认值的String型成员
    String value() default "默认构造方法";
}
