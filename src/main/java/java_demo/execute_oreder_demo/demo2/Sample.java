package java_demo.execute_oreder_demo.demo2;

/**
 * 继承初始化顺序 : 父类静态代码块或变量——>子类静态代码块或变量——>父类成员变量——>父类无参构造函数
 *                          ——>子类成员变量——>子类构造函数
 */
class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }

    public static void main(String str[]) {
        new TestSub();
    }
}

class Test {
    static {
        System.out.println("父类static 块 1  执行");
    }

    static Sample staticSam1 = new Sample("父类 静态成员staticSam1初始化");
    Sample sam1 = new Sample("父类 sam1成员初始化");
    static Sample staticSam2 = new Sample("父类 静态成员staticSam2初始化");

    static {
        System.out.println("父类 static 块 2  执行");
    }

    Test() {
        System.out.println("父类 Test默认构造函数被调用");
    }

    Sample sam2 = new Sample("父类 sam2成员初始化");

}

class TestSub extends Test {
    static Sample staticSamSub = new Sample("子类 静态成员staticSamSub初始化");

    TestSub() {
        System.out.println("子类 TestSub 默认构造函数被调用");
    }

    Sample sam1 = new Sample("子类 sam1成员初始化");
    static Sample staticSamSub1 = new Sample("子类 静态成员staticSamSub1初始化");

    static {
        System.out.println("子类 static 块  执行");
    }

    Sample sam2 = new Sample("子类 sam2成员初始化");
}
