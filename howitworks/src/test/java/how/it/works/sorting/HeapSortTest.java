package how.it.works.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSortTest {
    HeapSort heap = new HeapSort();

    @Test
    public void sort() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        int[] expected = new int[]{22, 15, 10, 8, 7, 5, 1};
        int[] result = heap.sort(seq);
        assertTrue(Arrays.equals(result, expected));
    }

    @Test
    public void heapify() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        heap.heapify(seq);
        System.out.println(Arrays.toString(seq));
        int[] expected = new int[]{22, 10, 15, 1, 8, 5, 7};
        assertTrue(Arrays.equals(seq, expected));
    }

    @Test
    public void siftUp() {
    }

    @Test
    public void swap() {
        int[] seq = new int[]{10, 1, 5, 22, 8, 15, 7};
        heap.swap(seq, 1, 5);
        assertEquals(15, seq[1]);
        assertEquals(1, seq[5]);
    }

    @Test
    public void iParent() {
        assertEquals(0, heap.iParent(0));
        assertEquals(0, heap.iParent(1));
        assertEquals(0, heap.iParent(2));
        assertEquals(1, heap.iParent(3));
    }
}