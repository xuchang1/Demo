import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo4 {
    @Test
    public void test1() {
        int[] array = {12, 4, 5, 14, 22, 88, 79, 3, 10};
        Arrays.sort(array);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
