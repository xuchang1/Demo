package test1;

class Person{
    String name;
    int age;
    public void tell(){
        System.out.println("姓名:"+name+",年龄:"+age);
    }
}

public class Test03{
    public static void main(String[] args) {
        Person per1=new Person();
        Person per2=per1;

        per1.name="张三";
        per1.age=30;
        per2.age=33;

        per1.tell();
        per2.tell();
    }
}