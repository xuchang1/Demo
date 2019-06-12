package java_demo.enum_demo;

public class demo2 {
    enum Constants{
        Constants_A,
        Constants_B
    }

    public static void main(String[] args) {
        Constants Constant_C = Constants.valueOf("abc");
        Constants[] constants = Constants.values();
        for (int i = 0; i < constants.length; i++) {
            System.out.println(constants[i]);
        }
    }
}
