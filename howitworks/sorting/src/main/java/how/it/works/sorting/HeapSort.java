package how.it.works.sorting;

import java.util.Arrays;

/**
 * @invariant root >= all children => max heap, otherwise, min heap
 *
 * key operations to keep the invariant:
 *  1) sift up
 *  2) sift down
 *  3) put the last item to the root
 *
 * sort:
 *  1) popup the root to get the next item
 *  2) put the last item onto the root
 *  3) sift down the root to the right level to keep the heap invariant
 * build or insert:
 *  1) append the new item at the end
 *  2) sift up the last item to the right level
 * delete:
 *  1) put the last item onto the delete node
 *  2) sift it up if it is larger than its parent, otherwise sift it down
 * update:
 *  sift it up if it is larger than its parent, otherwise sift it down
 *
 */
public class HeapSort {
    /**
     * cost: O(n*log(n))
     *
     * @param a
     * @return
     */
    public int[] sort(int[] a) {
        heapify(a); //cost: O(n*log(n))
        int[] result = new int[a.length];
        int end = a.length;
        for (int i = 0; i < result.length; i++) {// cost: O(n)
            result[i] = a[0];//pop the top item which is the largest item
            a[0] = a[end - 1];//put the last onto the root to do sift down
            end--;//shrink the length of a
            siftDown(a, 0, end);//sift down the root to the right level, cost: O(log(n))
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * cost: O(n*log(n))
     *
     * @param a
     */
    public void heapify(int[] a) {
        for (int i = 1; i < a.length; i++) { // cost: O(n)
            siftUp(a, i);// cost: O(log(n))
        }
    }

    /**
     * sift up the ith item to the right level
     *
     * @param a
     * @param i
     */
    public void siftUp(int[] a, int i) {
        if (i == 0) {
            return;
        }
        int j = i;
        int iParent = iParent(j);
        while (j > 0 & a[j] > a[iParent]) {
            swap(a, j, iParent);
            j = iParent;
            iParent = iParent(j);
        }
    }

    /**
     * sift down the ith item to the right level
     * @param a
     * @param i
     * @param length
     */
    public void siftDown(int[] a, int i, int length) {
        int j = i;
        int iLeft = iLeft(j);
        while (iLeft < length) {// there is still deeper level
            int iRight = iRight(j);
            if (iRight < length & a[iRight] > a[iLeft] & a[iRight] > a[j]) {// the right one is the largest, then down to the right
                swap(a, iRight, j);
                j = iRight;
            } else if (a[iLeft] > a[j]) { // down to the left
                swap(a, iLeft, j);
                j = iLeft;
            } else {
                break;
            }
            iLeft = iLeft(j);
        }
    }

    private int iRight(int i) {
        return 2 * i + 2;
    }

    private int iLeft(int i) {
        return 2 * i + 1;
    }


    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int iParent(int i) {
        return (i - 1) / 2;
    }
}
