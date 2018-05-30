package how.it.works.sorting;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Utils {
    public static void printArray(int[] seq) {
        System.out.println(Arrays.toString(seq));
    }

    public static void compareArray(int[] a1, int[] a2) {
        assertTrue(Arrays.equals(a1, a2));
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        System.out.println(3/2);
        System.out.println(5/2);
    }
}
