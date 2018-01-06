package how.it.works.sorting;

import static org.junit.Assert.assertEquals;

public class Utils {
    public static void printArray(int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i] + ", ");
        }
    }

    public static void compareArray(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            assertEquals(a1[i], a2[i]);
        }
    }
}
