package how.it.works.sorting;

public class HeapSort {
    public void sort(int[] a) {
        heapify(a);
    }

    public void heapify(int[] a) {
        for (int i = 1; i < a.length; i++) {
            siftUp(a, i);
        }
    }

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

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int iParent(int i) {
        return (i - 1) / 2;
    }
}
