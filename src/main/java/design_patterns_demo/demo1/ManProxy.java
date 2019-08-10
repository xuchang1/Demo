package design_patterns_demo.demo1;

public class ManProxy extends Person {

    private Person person;

    public ManProxy(Person person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println("say before");
        person.say();
        System.out.println("say after");
    }

    @Override
    void call() {
        System.out.println("call before");
        person.call();
        System.out.println("call after");
    }
}
