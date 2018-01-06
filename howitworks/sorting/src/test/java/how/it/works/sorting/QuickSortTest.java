package how.it.works.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();
    private int[] seq;
    private int[] sorted;

    @Before
    public void setUp() throws Exception {
        seq = new int[]{3, 1, 5, 22, 8, 5, 7};
        sorted = new int[]{1, 3, 5, 5, 7, 8, 22};
    }

    @Test
    public void sort() {
        quickSort.sort(seq);

        for (int i = 0; i < seq.length; i++) {
            assertEquals("should equal", seq[i], sorted[i]);
        }
    }

    @After
    public void tearDown() throws Exception {
    }
}