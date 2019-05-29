package test1;

public class test2 {
    public static void main(String[] args) {
        String s1 = "ja";
        String s2 = "va";
        String s3 = "java";
        String s4 = s1 + s2;
        System.out.println(s3 + "," + s4);
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true
    }
}
