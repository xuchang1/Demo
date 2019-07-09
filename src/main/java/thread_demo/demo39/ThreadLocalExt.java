package thread_demo.demo39;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal<Date> {

    @Override
    protected Date initialValue() {
        return new Date();
    }
}
