public class InsertionSortTest {

    public static void main(String[] args) {

        int[] serviceTimes = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        InsertionSort.sort(serviceTimes);

        for (int time : serviceTimes) {
            System.out.print(time + " ");
        }

    }

}