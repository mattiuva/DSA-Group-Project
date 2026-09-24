import java.util.Scanner;

public class ServiceCentre {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue waitingQueue = new Queue();

        StudentLinkedList studentRecords = new StudentLinkedList();

        int studentsServed = 0;
        int totalServiceTime = 0;

        int[] serviceTimesServed = new int[100];

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("      NUST SERVICE CENTRE SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add student to waiting queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add student service record");
            System.out.println("5. Display student service records");
            System.out.println("6. Search for student record");
            System.out.println("7. Remove student record");
            System.out.println("8. Display daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

    scanner.nextLine();

    System.out.print("Enter student number: ");
    String studentNumber = scanner.nextLine();

    System.out.print("Enter student name: ");
    String name = scanner.nextLine();

    System.out.print("Enter service type: ");
    String serviceType = scanner.nextLine();

    System.out.print("Enter estimated service time (minutes): ");
    int estimatedServiceTime = scanner.nextInt();

    Student student = new Student(
            studentNumber,
            name,
            serviceType,
            estimatedServiceTime
    );

    waitingQueue.enqueue(student);

    System.out.println("Student added to the waiting queue.");

    break;

                case 2:

    if (waitingQueue.isEmpty()) {

        System.out.println("There are no students waiting.");

    } else {

         Student servedStudent = waitingQueue.dequeue();

        serviceTimesServed[studentsServed] =
        servedStudent.getEstimatedServiceTime();

        studentsServed++;

        totalServiceTime += servedStudent.getEstimatedServiceTime();

        System.out.println("Student served successfully.");
        System.out.println("Student Number: " + servedStudent.getStudentNumber());
        System.out.println("Name: " + servedStudent.getName());
        System.out.println("Service Type: " + servedStudent.getServiceType());

    }

    break;

                case 3:

    System.out.println();
    System.out.println("=== Students Waiting in Queue ===");

    waitingQueue.displayQueue();

    break;

                case 4:

    scanner.nextLine();

    System.out.print("Enter student number: ");
    String recordStudentNumber = scanner.nextLine().trim();

    System.out.print("Enter student name: ");
    String recordName = scanner.nextLine();

    System.out.print("Enter service type: ");
    String recordServiceType = scanner.nextLine();

    System.out.print("Enter estimated service time (minutes): ");
    int recordServiceTime = scanner.nextInt();

    Student recordStudent = new Student(
            recordStudentNumber,
            recordName,
            recordServiceType,
            recordServiceTime
    );

    studentRecords.insertStudent(recordStudent);

    System.out.println("Student service record added successfully.");

    break;

                case 5:

    System.out.println();
    System.out.println("=== Student Service Records ===");

    studentRecords.displayStudents();

    break;

                case 6:

    scanner.nextLine();

    System.out.print("Enter student number to search: ");
    String searchStudentNumber = scanner.nextLine().trim();

    Student foundStudent = studentRecords.searchStudent(searchStudentNumber);

    if (foundStudent != null) {

        System.out.println();
        System.out.println("=== Student Record Found ===");

        System.out.println("Student Number: "
                + foundStudent.getStudentNumber());

        System.out.println("Name: "
                + foundStudent.getName());

        System.out.println("Service Type: "
                + foundStudent.getServiceType());

        System.out.println("Estimated Service Time: "
                + foundStudent.getEstimatedServiceTime()
                + " minutes");

    } else {

        System.out.println("Student record not found.");

    }

    break;

                case 7:

    scanner.nextLine();

    System.out.print("Enter student number to remove: ");
    String removeStudentNumber = scanner.nextLine().trim();

    boolean removed = studentRecords.deleteStudent(removeStudentNumber);

    if (removed) {

        System.out.println("Student record removed successfully.");

    } else {

        System.out.println("Student record not found.");

    }

    break;

                case 8:

    System.out.println();
    System.out.println("=== Daily Statistics ===");

    System.out.println("Students currently waiting: "
            + waitingQueue.size());

    System.out.println("Students served: "
            + studentsServed);

    if (studentsServed > 0) {

        int totalTime = 0;
        int highestTime = serviceTimesServed[0];
        int lowestTime = serviceTimesServed[0];
        int longerThan10 = 0;

        for (int i = 0; i < studentsServed; i++) {

            totalTime += serviceTimesServed[i];

            if (serviceTimesServed[i] > highestTime) {

                highestTime = serviceTimesServed[i];

            }

            if (serviceTimesServed[i] < lowestTime) {

                lowestTime = serviceTimesServed[i];

            }

            if (serviceTimesServed[i] > 10) {

                longerThan10++;

            }

        }

        double averageTime =
                (double) totalTime / studentsServed;

        System.out.println("Total service time: "
                + totalTime + " minutes");

        System.out.println("Average service time: "
                + averageTime + " minutes");

        System.out.println("Highest service time: "
                + highestTime + " minutes");

        System.out.println("Lowest service time: "
                + lowestTime + " minutes");

        System.out.println("Services longer than 10 minutes: "
                + longerThan10);

    } else {

        System.out.println("Total service time: 0 minutes");
        System.out.println("Average service time: 0 minutes");
        System.out.println("Highest service time: 0 minutes");
        System.out.println("Lowest service time: 0 minutes");
        System.out.println("Services longer than 10 minutes: 0");

    }

    break;

                case 9:

    int[] serviceTimes = waitingQueue.getServiceTimes();

    if (serviceTimes.length == 0) {

        System.out.println("There are no students waiting to sort.");

    } else {

        System.out.println();
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.print("Enter your choice: ");

        int sortChoice = scanner.nextInt();

        if (sortChoice == 1) {

            SelectionSort.sort(serviceTimes);

            System.out.println("Service times sorted using Selection Sort.");

        } else if (sortChoice == 2) {

            InsertionSort.sort(serviceTimes);

            System.out.println("Service times sorted using Insertion Sort.");

        } else {

            System.out.println("Invalid sorting choice.");
            break;
        }

        System.out.print("Sorted service times: ");

        for (int time : serviceTimes) {

            System.out.print(time + " ");
        }

        System.out.println();
    }

    break;

                                case 10:

                    System.out.println();
                    System.out.println("=== Part C Sorting Experiment ===");

                    SortExperiment.runPartCExperiment();

                    break;

                case 11:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 11);

        scanner.close();
    }

}