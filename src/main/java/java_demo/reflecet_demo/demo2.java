package java_demo.reflecet_demo;

/**
 * 通过class获取成员变量
 *      1、getFields() : 获取public的成员变量(包括父类中的)
 *      2、getField(String name) : 根据名称获取public成员变量(包括父类中的))
 *      3、getDeclaredFields() : 获取本类中的所有成员变量
 *      3、getDeclaredField(String name) : 根据名称获取本类中的成员变量
 *
 * Field方法
 *      1、getName() : 获得该成员变量名称
 *      2、getType() : 获取该成员变量类型的class对象
 *      3、get(Object obj) : 获取指定对象obj中该成员变量的值
 *      4、set(Object obj, Object value) : 将指定对象obj中该成员变量的值设置为value
 *      5、setAccessible(boolean flag) : 设置为true值，可修改private修饰的成员变量的值，反之操作抛出异常
 *      6、getModifiers() : 获得该成员变量修饰符的整数
 *
 *      根据具体类型，get、set方法还有如下几种
 *      getInt(Object obj)、setInt(Object obj, int value)
 *      getFloat(Object obj)、setFloat(Object obj, float value)
 *      getBoolean(Object obj)、setBoolean(Object obj, boolean value)
 */
public class demo2 extends parent_demo2{
    int i;

    public float f;

    protected boolean b;

    private String s;

    public demo2(int i, float f, boolean b, String s) {
        this.i = i;
        this.f = f;
        this.b = b;
        this.s = s;
    }
}
