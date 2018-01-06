package how.it.works.sorting;

public class MergeSort {
    /**
     * @param seq
     * @param begin, inclusive
     * @param end,   exclusive
     * @return
     */
    public int[] sort(int[] seq, int begin, int end) {
        if (seq == null) {
            return null;
        }
        if (begin < 0 || end > seq.length || begin >= end) {
            throw new IllegalArgumentException("invalid args");
        }
        if (end - begin == 1) {
            return new int[]{seq[begin]};
        }
        assert end - begin > 1 : "the length of the seq should be larger than 1 from here";

        int middle = (begin + end) / 2;

        int[] left = sort(seq, begin, middle);
        int[] right = sort(seq, middle, end);

        int[] result = merge(left, right);

        return result;
    }

    private int[] merge(int[] left, int[] right) {
        int sum = left.length + right.length;
        int[] result = new int[sum];// the extra space of order n is needed to hold merge result
        int l = 0, r = 0;
        for (int i = 0; i < sum; i++) {
            int next;
            if (l == left.length) {
                next = right[r];
                r++;
            } else if (r == right.length) {
                next = left[l];
                l++;
            } else if (right[r] < left[l]) {
                next = right[r];
                r++;
            } else {
                next = left[l];
                l++;
            }
            result[i] = next;
        }
        return result;
    }
}
