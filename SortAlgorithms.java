public class SortAlgorithms {

    /**
     * Mutable counter used to count only comparisons between data values.
     * Loop-index and boundary checks (e.g. j >= 0, i <= mid) are NOT counted.
     */
    public static final class Counter {
        public long comparisons = 0;
    }

    public static void selectionSort(int[] arr, Counter c) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                c.comparisons++;                    // data comparison
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    public static void insertionSort(int[] arr, Counter c) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                c.comparisons++;                    // data comparison
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, Counter c) {
        if (arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1, c);
    }

    private static void mergeSort(int[] arr, int[] temp, int low, int high, Counter c) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, temp, low, mid, c);
            mergeSort(arr, temp, mid + 1, high, c);
            merge(arr, temp, low, mid, high, c);
        }
    }

    private static void merge(int[] arr, int[] temp, int low, int mid, int high, Counter c) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            c.comparisons++;                        // data comparison
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= high) {
            arr[k++] = temp[j++];
        }
    }

    public static void quickSort(int[] arr, Counter c) {
        quickSort(arr, 0, arr.length - 1, c);
    }

    private static void quickSort(int[] arr, int low, int high, Counter c) {
        if (low < high) {
            int p = partition(arr, low, high, c);
            quickSort(arr, low, p - 1, c);
            quickSort(arr, p + 1, high, c);
        }
    }

    private static int partition(int[] arr, int low, int high, Counter c) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            c.comparisons++;                        // data comparison
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
