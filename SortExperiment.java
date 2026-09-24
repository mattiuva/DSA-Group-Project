import java.util.Arrays;
import java.util.Random;

public class SortExperiment {

    private interface SortFn {
        void sort(int[] arr, SortAlgorithms.Counter c);
    }

    private static final class NamedSort {
        final String name;
        final SortFn fn;

        NamedSort(String name, SortFn fn) {
            this.name = name;
            this.fn = fn;
        }
    }

    public static void main(String[] args) {

        NamedSort[] sorts = {
            new NamedSort("Selection Sort", SortAlgorithms::selectionSort),
            new NamedSort("Insertion Sort", SortAlgorithms::insertionSort),
            new NamedSort("Merge Sort",     SortAlgorithms::mergeSort),
            new NamedSort("Quick Sort",     SortAlgorithms::quickSort)
        };

        Random rng = new Random(42);

        int[] sizes = {20, 50, 100, 500};

        System.out.println("PART C - ALGORITHM EXPERIMENT");
        System.out.println("==============================");
        printHeader();

        int[] original100 = null;

        for (int size : sizes) {

            int[] original = randomArray(rng, size);

            if (size == 100) {
                original100 = Arrays.copyOf(original, original.length);
            }

            runExperiment(sorts, original);
        }

        System.out.println();
        System.out.println("ADDITIONAL TEST - ALMOST-SORTED 100-ELEMENT ARRAY");
        System.out.println("==================================================");
        printHeader();

        int[] almostSorted = createAlmostSortedArray(original100);

        runExperiment(sorts, almostSorted);
    }

    private static int[] randomArray(Random rng, int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rng.nextInt(1_000_000);
        }

        return arr;
    }

    private static int[] createAlmostSortedArray(int[] base) {


        int[] arr = Arrays.copyOf(base, base.length);

        Arrays.sort(arr);

        int[][] pairs = {
            {0, 1},
            {2, 3},
            {4, 5},
            {6, 7},
            {8, 9}
        };


        for (int[] pair : pairs) {

            int temp = arr[pair[0]];
            arr[pair[0]] = arr[pair[1]];
            arr[pair[1]] = temp;
        }

        return arr;
    }

    private static void runExperiment(
            NamedSort[] sorts,
            int[] original) {

        for (NamedSort sort : sorts) {
            printRow(sort, original);
        }
    }

    private static void printRow(
            NamedSort sort,
            int[] original) {

        SortAlgorithms.Counter counter =
                new SortAlgorithms.Counter();

        int[] copy =
                Arrays.copyOf(original, original.length);

        long start = System.nanoTime();

        sort.fn.sort(copy, counter);

        long end = System.nanoTime();

        long executionTime = end - start;

        System.out.printf(
                "%-16s %-12d %14d %16d%n",
                sort.name,
                original.length,
                counter.comparisons,
                executionTime
        );
    }

    private static void printHeader() {

        System.out.printf(
                "%-16s %-12s %14s %16s%n",
                "Algorithm",
                "Input Size",
                "Comparisons",
                "Time (ns)"
        );

        System.out.println(
                "------------------------------------------------------------"
        );
    }
}