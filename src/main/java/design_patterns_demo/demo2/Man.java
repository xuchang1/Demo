package design_patterns_demo.demo2;

public class Man implements Person {
    @Override
    public String say(String str) {
        System.out.println("man say()");
        return str;
    }

//    @Override
//    public void call() {
//        System.out.println("man call()");
//    }
}
