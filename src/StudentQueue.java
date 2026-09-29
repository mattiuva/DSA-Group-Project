public class StudentQueue {

    // Maximum number of students
    private static final int MAX_SIZE = 50;

    // Array used to store students
    private Student[] queue;

    // Front points to the first student
    private int front;

    // Rear points to the last student
    private int rear;

    // Number of students currently in queue
    private int size;

    // Constructor
    public StudentQueue() {
        queue = new Student[MAX_SIZE];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ENQUEUE
    // Adds a student to the rear of the queue
    public void enqueue(Student student) {

        if (size == MAX_SIZE) {
            System.out.println("Queue is full.");
            return;
        }

        rear++;
        queue[rear] = student;
        size++;

        System.out.println(student.getName() + " added to the waiting queue.");
    }

    // DEQUEUE
    // Removes and returns the student at the front
    public Student dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        Student student = queue[front];

        // Move all remaining students one position forward
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        queue[size - 1] = null;

        rear--;
        size--;

        return student;
    }

    // PEEK
    // Returns the first student without removing them
    public Student peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        return queue[front];
    }

    // ISEMPTY
    public boolean isEmpty() {
        return size == 0;
    }

    // DISPLAY QUEUE
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.println("                  STUDENTS WAITING FOR SERVICE");
        System.out.println("==============================================================");

        System.out.printf("%-12s %-15s %-20s %-10s%n",
                "Student No", "Name", "Service Type", "Time(min)");

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < size; i++) {
            queue[i].displayStudent();
        }

        System.out.println("==============================================================");
    }

    // Returns number of students currently in queue
    public int getSize() {
        return size;
    }
}
