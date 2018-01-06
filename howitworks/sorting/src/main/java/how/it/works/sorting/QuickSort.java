package how.it.works.sorting;

public class QuickSort {


    public void sort(int[] seq) {
        partition(seq, 0, seq.length);
    }

    /**
     * partition the portion of the sequence from begin to end recursively and in place
     *
     * @param seq
     * @param begin, inclusive
     * @param end,   exclusive
     */
    public void partition(int[] seq, int begin, int end) {
        if (seq == null || end - begin <= 1) {// only seq with length larger than 1 is needed to partition
            return;
        }
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

        partition(seq, begin, i); // left part

        partition(seq, i + 1, end); // right part, i+1 excludes i because i is the final place of pivot


    }
}
