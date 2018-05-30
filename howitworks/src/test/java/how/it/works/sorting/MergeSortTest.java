package how.it.works.sorting;

import org.junit.Test;

import static how.it.works.sorting.Utils.compareArray;
import static how.it.works.sorting.Utils.printArray;

public class MergeSortTest {
    MergeSort sort = new MergeSort();
    @Test
    public void sort() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] expected = new int[]{1, 5, 7, 8, 10, 15, 22};
        int[] result = sort.sort(seq, 0, seq.length);
        printArray(result);
        compareArray(result, expected);
    }

}