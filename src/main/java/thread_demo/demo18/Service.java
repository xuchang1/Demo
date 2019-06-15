package thread_demo.demo18;

public class Service {
    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() +
                    " run begin time = " + System.currentTimeMillis());

            while (true) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("ThreadName = " + Thread.currentThread().getName() +
                            " run Exception time = " + System.currentTimeMillis() );

                    Integer.parseInt("a");
                    /*try {
                        Integer.parseInt("a");
                    } catch (Exception e){
                        e.printStackTrace();
                    }*/
                }
            }
        } else {
            System.out.println("Thread B run time = " + System.currentTimeMillis());
        }
    }
}
