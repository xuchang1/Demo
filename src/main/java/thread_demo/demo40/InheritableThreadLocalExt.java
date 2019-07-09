package thread_demo.demo40;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal<Date> {
    @Override
    protected Date initialValue() {
        return new Date();
    }
}
