package how.it.works.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void sort() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] sorted = new int[]{1, 3, 5, 8, 10, 15, 22};
        quickSort.sort(seq);

        printArray(seq);


        compareArray(seq, sorted);
    }

    private void printArray(int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            System.out.println(seq[i]);
        }
    }

    private void compareArray(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            assertEquals(a1[i], a2[i]);
        }
    }

    @Test
    public void partition() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] expect = new int[]{7, 1, 5, 8, 10, 15, 22};
        quickSort.partition(seq, 0, seq.length);

        printArray(seq);

        compareArray(seq, expect);
    }
}