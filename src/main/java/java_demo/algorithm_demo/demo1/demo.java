package java_demo.algorithm_demo.demo1;

/**
 * 冒泡算法
 */
public class demo {
    public static void main(String[] args) {
        int array[] = new int[]{2,3,1,5,4};
//        sort1(array);

        sort2(array);
        print(array);
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    static int[] sort1(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    static int[] sort2(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
