1、demo1和demo2
    线程中的成员变量，什么时候会被共享，什么时候不会.
    当该成员变量属于一个对象时，可以被共享;属于不同对象时，不可被共享

2、demo3和demo4
    当各个线程中，某一个对象的地址的相同的，即共享该对象。基本数据类型会在实例化对象的时候初始化，对应的变量地址并不相同，固不共享.
    理解这4个demo，理解多线程中，变量什么时候会共享，什么时候不共享。
    
demo19 : synchronized (this)同步代码块的使用。

demo20 : 多线程访问同一对象方法，synchronized的地方同步访问，不在synchronized中的代码异步访问。

demo21 : 线程A、B虽然访问不同方法，但是都要先获取这些方法的同一个对象service的锁，顾不同方法之间同步。

demo22 : java支持将任意对象作为对象监视器来实现同步功能。

demo23 : synchronized修饰静态方法，获取的是当前类(class)的锁。

demo24 : Class锁对所有该类对象实例都起作用.

demo25 : synchronized(x.class) : 同步代码块，监视对象为类x，访问需要向获取类x的class锁.

demo26 : synchronized同步监视String字符串时，注意String常量池缓存功能（a == b）.

demo27 : 死锁。main方法中，如果不休眠，则不会产生死锁，why？

demo28 : 修改同步对象的属性，只要对象不变，就不会改变同步的结果。