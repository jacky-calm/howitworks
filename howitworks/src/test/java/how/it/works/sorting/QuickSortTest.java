package how.it.works.sorting;

import org.junit.Test;

import static how.it.works.sorting.Utils.compareArray;
import static how.it.works.sorting.Utils.printArray;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Test
    public void sort() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] sorted = new int[]{1, 5, 7, 8, 10, 15, 22};
        quickSort.sort(seq, 0, seq.length);
        printArray(seq);
        compareArray(seq, sorted);
    }

    @Test
    public void partition1() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] expect = new int[]{7, 1, 5, 8, 10, 15, 22};
        quickSort.partition(seq, 0, seq.length);
        printArray(seq);
        compareArray(seq, expect);
    }

    @Test
    public void partition2() {
        int[] seq = new int[]{10, 11, 5, 22, 8, 15, 11};
        int[] expect = new int[]{8, 5, 10, 22, 11, 15, 11};
        quickSort.partition(seq, 0, seq.length);
        printArray(seq);
        compareArray(seq, expect);
    }

    @Test
    public void partition3() {
        int[] seq = new int[]{10, 11, 5, 22, 8, 15, 10};
        int[] expect = new int[]{10, 5, 8, 10, 11, 15, 22};
        quickSort.partition(seq, 0, seq.length);
        printArray(seq);
        compareArray(seq, expect);
    }
}