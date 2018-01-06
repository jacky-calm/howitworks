package how.it.works.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class RandomQuickSort {
    /**
     * sort the portion of the sequence from begin to end recursively and in place
     *
     * @param seq
     * @param begin
     * @param end
     */
    public void sort(int[] seq, int begin, int end) {
        if (seq == null || end - begin <= 1) {// only seq with length larger than 1 is needed to sort
            return;
        }
        // divide and conquer
        int p = partition(seq, begin, end);// the pivot is now in the final place
        sort(seq, begin, p); // sort the left part
        sort(seq, p + 1, end); // sort the right part, p+1 excludes p because p is the final place of pivot
    }

    /**
     * partition the portion of the sequence from begin to end in place
     *
     * @param begin, inclusive
     * @param end,   exclusive
     * @param seq
     * @return the index of pivot
     */
    public int partition(int[] seq, int begin, int end) {
        if (seq == null || end - begin <= 1) {// only seq with length larger than 1 is needed to partition
            return begin;
        }
        randomPivot(seq, begin, end);
        int pivot = seq[begin];
        int i = begin; //@invariant i always points to the last item which is smaller or equal than pivot
        for (int j = begin + 1; j < end; j++) {// loop on seq once which means the cost is order n (end-begin).
            if (seq[j] <= pivot) {//@invariant j tries to probe an item which is smaller or equal than pivot
                i++; // move to next item which is <= pivot so that it keeps the @invariant
                //switch items at i+1 and j.
                int tem = seq[i];
                seq[i] = seq[j];
                seq[j] = tem;
            }
        }
        // switch items at begin and i which means put pivot into the right place
        seq[begin] = seq[i];
        seq[i] = pivot;
        return i;
    }

    private void randomPivot(int[] seq, int begin, int end) {
        int randomP = ThreadLocalRandom.current().nextInt(begin, end);
        int tem = seq[begin];
        seq[begin] = seq[randomP];
        seq[randomP] = tem;
    }
}
