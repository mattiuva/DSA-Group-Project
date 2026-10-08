public class ArrayStatistics {
    public static void main(String[]args){

        int[]serviceTimes = {12,5,8,4,15,11};

        int totalServiceTimes = 0;
        int highestServiceTime = serviceTimes[0];
        int lowestServiceTime = serviceTimes[0];
        int longerThan10 = 0;

        for (int i = 0; i < serviceTimes.length; i++) {
            totalServiceTimes += serviceTimes[i];

            if (serviceTimes[i] > highestServiceTime) {
                highestServiceTime = serviceTimes[i];
            }

            if (serviceTimes[i] < lowestServiceTime) {
                lowestServiceTime = serviceTimes[i];
            }

            if (serviceTimes[i] > 10) {
                longerThan10++;
            }
        }

        int totalStudents = serviceTimes.length;
        double averageServiceTime = (double) totalServiceTimes / totalStudents;

        System.out.println("Daily Service Times Statistics:");
        System.out.println("================================");
        System.out.println("Total Students Served: " + totalStudents);
        System.out.println("Total Service Times: " + totalServiceTimes);
        System.out.println("Average Service Time: " + averageServiceTime);
        System.out.println("Highest Service Time: " + highestServiceTime);
        System.out.println("Lowest Service Time: " + lowestServiceTime);
        System.out.println("Number of Students with Service Time > 10: " + longerThan10);
    }
}