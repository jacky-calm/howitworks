package how.it.works.sorting;

import org.junit.Test;

import static how.it.works.sorting.Utils.compareArray;
import static how.it.works.sorting.Utils.printArray;
import static org.junit.Assert.*;

public class RandomQuickSortTest {
    RandomQuickSort quickSort = new RandomQuickSort();
    @Test
    public void sort() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] sorted = new int[]{1, 5, 7, 8, 10, 15, 22};
        quickSort.sort(seq, 0, seq.length);
        printArray(seq);
        compareArray(seq, sorted);
    }
}