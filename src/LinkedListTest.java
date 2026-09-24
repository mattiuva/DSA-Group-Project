public class LinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList studentList = new StudentLinkedList();

        Student maria = new Student(
                "221045678",
                "Maria",
                "Registration",
                12
        );

        Student tomas = new Student(
                "222034512",
                "Tomas",
                "Student Card",
                5
        );

        Student ndapewa = new Student(
                "223041876",
                "Ndapewa",
                "Fees",
                8
        );

        Student simon = new Student(
                "221067341",
                "Simon",
                "Documents",
                4
        );

        Student petrus = new Student(
                "224019988",
                "Petrus",
                "Academic Enquiry",
                10
        );

        System.out.println("=== Task A2: Student Service Records ===");

        // Insert Maria at the end
        System.out.println();
        System.out.println("Insert Maria at END:");
        studentList.insertStudent(maria, "end");
        studentList.displayStudents();

        // Insert Tomas at the end
        System.out.println();
        System.out.println("Insert Tomas at END:");
        studentList.insertStudent(tomas, "end");
        studentList.displayStudents();

        // Insert Ndapewa at the beginning
        System.out.println();
        System.out.println("Insert Ndapewa at BEGINNING:");
        studentList.insertStudent(ndapewa, "beginning");
        studentList.displayStudents();

        // Insert Simon at position 3
        System.out.println();
        System.out.println("BEFORE inserting Simon at position 3:");
        studentList.displayStudents();

        studentList.insertStudent(simon, "3");

        System.out.println("AFTER inserting Simon at position 3:");
        studentList.displayStudents();

        // Insert Petrus at position 4
        System.out.println();
        System.out.println("BEFORE inserting Petrus at position 4:");
        studentList.displayStudents();

        studentList.insertStudent(petrus, "4");

        System.out.println("AFTER inserting Petrus at position 4:");
        studentList.displayStudents();

        // Search
        System.out.println();
        System.out.println("=== Search Student ===");

        Student foundStudent =
                studentList.searchStudent("222034512");

        if (foundStudent != null) {

            System.out.println(
                    "Found: "
                    + foundStudent.getName()
                    + ", "
                    + foundStudent.getServiceType()
                    + ", "
                    + foundStudent.getEstimatedServiceTime()
                    + " minutes"
            );

        } else {

            System.out.println("Student not found.");

        }

        // Delete Maria
        System.out.println();
        System.out.println("BEFORE deleting Maria:");
        studentList.displayStudents();

        boolean deleted =
                studentList.deleteStudent("221045678");

        if (deleted) {

            System.out.println("Maria deleted successfully.");

        }

        System.out.println("AFTER deleting Maria:");
        studentList.displayStudents();

        // Final traversal
        System.out.println();
        System.out.println("=== Final Traversal ===");
        studentList.displayStudents();

    }

}