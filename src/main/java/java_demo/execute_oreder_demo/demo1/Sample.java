package java_demo.execute_oreder_demo.demo1;

/**
 * 初始化顺序 : 静态代码块或变量——>成员变量——>构造函数
 *
 * 每个内部的执行顺序，只和声明顺序有关
 */
class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }

    public static void main(String str[]) {
        Test a = new Test("a");
    }

}

/*class Test {
    static Sample sam = new Sample("静态成员sam初始化");
    Sample sam1 = new Sample("sam1成员初始化");

    static {
        System.out.println("static块执行");
        if (sam == null) System.out.println("sam is null");
        sam = new Sample("静态块内初始化sam成员变量");
    }

    Test() {
        System.out.println("Test默认构造函数被调用");
    }
}*/

class Test {
    static {
        System.out.println("static 块 1  执行");
    }

    static Sample staticSam1 = new Sample("静态成员staticSam1初始化");
    Sample sam1 = new Sample("sam1成员初始化");
    static Sample staticSam2 = new Sample("静态成员staticSam2初始化");

    static {
        System.out.println("static 块 2  执行");
    }

    Test() {
        System.out.println("Test默认构造函数被调用");
    }

    Test(String a) {
        System.out.println("Test有参构造函数被调用");
    }

    Sample sam2 = new Sample("sam2成员初始化");
}
