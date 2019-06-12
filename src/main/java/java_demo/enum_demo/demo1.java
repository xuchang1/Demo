package java_demo.enum_demo;

public class demo1 {
    enum Constants{
        Constants_A,
        Constants_B
    }

    public static void main(String[] args) {
        //枚举类中的每个成员都是类的实例
        Constants[] constants = Constants.values();
        for (int i = 0; i < constants.length; i++) {
            System.out.println(constants[i]);
        }
    }
}
