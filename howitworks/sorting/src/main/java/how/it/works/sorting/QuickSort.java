package how.it.works.sorting;

public class QuickSort {


    public void sort(int[] seq) {
        partition(seq, 0, seq.length);
    }

    public void partition(int[] seq, int begin, int end) {
        int pivot = seq[begin];
        int i = begin;
        for (int j = begin + 1; j < end; j++) {
            if (seq[j] < pivot) {
                i++;
                if (j > i) {
                    int tem = seq[i];
                    seq[i] = seq[j];
                    seq[j] = tem;
                }

            }
        }
        seq[begin] = seq[i];
        seq[i] = pivot;

    }
}
