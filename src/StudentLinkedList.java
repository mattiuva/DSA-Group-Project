public class StudentLinkedList {

    private StudentNode head;

    public StudentLinkedList() {

        head = null;

    }

    // Insert at the end
    public void insertStudent(Student student) {

        StudentNode newNode = new StudentNode(student);

        if (head == null) {

            head = newNode;
            return;
        }

        StudentNode current = head;

        while (current.next != null) {

            current = current.next;

        }

        current.next = newNode;
    }

    // Insert at beginning, end, or a specific position
    public void insertStudent(Student student, String position) {

        StudentNode newNode = new StudentNode(student);

        // Insert at beginning
        if (position.equalsIgnoreCase("beginning")) {

            newNode.next = head;
            head = newNode;
            return;
        }

        // Insert at end
        if (position.equalsIgnoreCase("end")) {

            if (head == null) {

                head = newNode;
                return;
            }

            StudentNode current = head;

            while (current.next != null) {

                current = current.next;

            }

            current.next = newNode;
            return;
        }

        // Insert at a specific position
        int pos;

        try {

            pos = Integer.parseInt(position);

        } catch (NumberFormatException e) {

            System.out.println("Invalid position.");
            return;
        }

        // Position 1 means beginning
        if (pos <= 1) {

            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the node before the required position
        StudentNode current = head;
        int count = 1;

        while (current != null && count < pos - 1) {

            current = current.next;
            count++;

        }

        // If position is beyond the list, add at the end
        if (current == null) {

            insertStudent(student);
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete a student using student number
    public boolean deleteStudent(String studentNumber) {

        if (head == null) {

            System.out.println("List is empty. Nothing to delete.");
            return false;
        }

        // Delete first student
        if (head.student.getStudentNumber().equals(studentNumber)) {

            head = head.next;
            return true;
        }

        StudentNode previous = head;
        StudentNode current = head.next;

        while (current != null
                && !current.student.getStudentNumber().equals(studentNumber)) {

            previous = current;
            current = current.next;
        }

        if (current == null) {

            System.out.println("Student " + studentNumber + " not found.");
            return false;
        }

        previous.next = current.next;

        return true;
    }

    // Search for a student
    public Student searchStudent(String studentNumber) {

        StudentNode current = head;

        while (current != null) {

            if (current.student.getStudentNumber().equals(studentNumber)) {

                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Display all students
    public void displayStudents() {

        if (head == null) {

            System.out.println("[ empty list ]");
            return;
        }

        StudentNode current = head;

        while (current != null) {

            System.out.println(
                    "[" +
                    current.student.getStudentNumber() + "|" +
                    current.student.getName() + "|" +
                    current.student.getServiceType() + "|" +
                    current.student.getEstimatedServiceTime() +
                    "min]"
            );

            current = current.next;
        }

        System.out.println("->NULL");
    }

}