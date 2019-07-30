package java_demo.demo;

public class OuterClass {

    //声明一个变量，存储内部类对象，初始化外部类对象后调用该成员变量即可获得内部类对象
    innerClass in = new innerClass();

    int a = 1;

    void do1() {
        System.out.println("外部类do1方法");
    }


    class innerClass {
        public innerClass() {
            System.out.println("内部类构造方法");
        }

        void do2(){
            //内部类可以调用外部类的属性和方法
            do1();
            System.out.println(a);
        }

    }
}
