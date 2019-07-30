package java_demo.demo;

public class mainDemo {
    public static void main(String[] args) {
        OuterClass out = new OuterClass();
        //通过外部类的引用，来new一个内部类对象
        OuterClass.innerClass inner = out.new innerClass();
        inner.do2();

        OuterClass.innerClass inner2 = out.in;
        inner2.do2();
    }
}
