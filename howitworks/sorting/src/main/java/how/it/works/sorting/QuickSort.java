package how.it.works.sorting;

public class QuickSort {


    public void sort(int[] seq) {
        partition(seq, 0, seq.length);
    }

    public void partition(int[] seq, int begin, int end) {
        int pivot = seq[begin];
        int i = begin; //@invariant i always points to the last item which is smaller or equal than pivot
        for (int j = begin + 1; j < end; j++) {
            if (seq[j] <= pivot) {//@invariant j tries to probe an item which is smaller or equal than pivot
                i++;
                if (j > i) {//switch items at i+1 and j
                    int tem = seq[i];
                    seq[i] = seq[j];
                    seq[j] = tem;
                }
            }
        }
        // switch items at begin and i which means put pivot into the right place
        seq[begin] = seq[i];
        seq[i] = pivot;

    }
}
