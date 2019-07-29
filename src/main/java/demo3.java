import org.junit.jupiter.api.Test;

/**
 * java基础
 */
public class demo3 {

    /**
     * 基本数据类型之间都可以进行强制转换吗？字符串不行？
     */
    @Test
    public void test1() {
        char word = 'd', word2 = '@';
        int p = 23045, p2 = 45213;

        System.out.println((int)word);
        System.out.println((int)word2);
        System.out.println((char)p);
        System.out.println((char)p2);
    }

    /**
     * 位运算
     */
    @Test
    public void test2() {
        int i = -5;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i>>>1));
        System.out.println(Integer.toHexString(i));
    }

    /**
     * 字符串
     */
    @Test
    public void test3() {

        /*//在字符串常量池中创建了一个对象
        String  s1 = "abc";
        //池中已存在，顾创建了0个对象
        String  s2 = "abc";
        //s1、s2指向同一对象的引用
        System.out.println(s1 == s2);  //true*/

        //--------------------------------------------------------------------------------------------

        /*//在字符串常量池中创建了一个对象，在堆中创建了一个对象。总共创建了2个对象
        String s1 = new String("abc");
        //只在堆中创建了一个对象
        String s2 = new String("abc");
        String s3 = "abc";
        //指向堆中内存地址不同
        System.out.println(s1 == s2);//false
        //s1指向堆中内存地址，s3指向常量池中内存地址
        System.out.println(s1 == s3);//false*/

        //--------------------------------------------------------------------------------------------

        /*//常量的值在编译的时候就被确定
        String s1 = "ab" + "cd";//1个对象
        String s2 = "abcd";
        System.out.println(s1 == s2);//true*/

        //--------------------------------------------------------------------------------------------

        /**
         * s3产生的过程 : 运行期JVM首先会在堆中创建一个StringBuilder对象，该对象通过s1对象完成初始化，然后调用append()
         * 方法完成拼接操作，最后调用toString()方法在堆中生成一个字符串对象，并将该对象的地址返回给s3。0
         */
        /*//整个过程产生了5个对象，字符串常量池中产生了3个对象，一个StringBuilder对象，堆中一个字符串对象
        String s1 = "ab";
        String s2 = "cd";
        String s3 = s1 + s2;
        String s4 = "abcd";
        System.out.println(s3 == s4);//false*/

        //--------------------------------------------------------------------------------------------

        /*//JAVA编译器对string + 基本类型/常量 是当成常量表达式直接求值来优化的。 即在编译的时候s5的值就被确定了。
        //s2的值是按照上一示例通过StringBuilder完成字符串的拼接的，s5的值是在编译器就确定了的
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "ab";
        System.out.println(s2 == s3);//false

        final String s4 = "a";
        String s5 = s4 + "b";
        System.out.println(s5 == s3);//true*/

        /*String str6 = "b";
        String str7 = "a" + str6;
        String str67 = "ab";
        System.out.println("str7 = str67 : "+ (str7 == str67));
        //↑str6为变量，在运行期才会被解析。
        final String str8 = "b";
        String str9 = "a" + str8;
        String str89 = "ab";
        System.out.println("str9 = str89 : "+ (str9 == str89));*/


        String s1 = new String("kvill");
        String s2 = s1.intern();
        System.out.println( s2 == s1 ); //false
        System.out.println( s1 == s1.intern() ); //false
        System.out.println( s2 == s1.intern() ); //true

    }
}
