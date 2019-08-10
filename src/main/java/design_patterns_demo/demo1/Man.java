package design_patterns_demo.demo1;

public class Man extends Person {
    @Override
    public void say() {
        System.out.println("man say()");
    }

    @Override
    void call() {
        System.out.println("man call()");
    }
}
