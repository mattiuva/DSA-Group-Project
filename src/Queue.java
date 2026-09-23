public class Queue {

    QueueNode front;
    QueueNode rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(Student student) {

        QueueNode newNode = new QueueNode(student);

        if (front == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }

    }

    public Student dequeue() {

    if (front == null) {
        return null;
    }

    Student servedStudent = front.student;
    front = front.next;

    if (front == null) {
    rear = null;
}

return servedStudent;

}

public Student peek() {

    if (front == null) {
    return null;
}

return front.student;

}

public boolean isEmpty() {

    return front == null;

}

public void displayQueue() {

    if (front == null) {
        System.out.println("The queue is empty.");
        return;
    }

    QueueNode current = front;

    while (current != null) {

        System.out.println("Student Number: " + current.student.getStudentNumber());
        System.out.println("Name: " + current.student.getName());
        System.out.println("Service Type: " + current.student.getServiceType());
        System.out.println("Estimated Service Time: " + current.student.getEstimatedServiceTime() + " minutes");

        current = current.next;
    }

}

public int size() {

    int count = 0;

    QueueNode current = front;

    while (current != null) {

        count++;

        current = current.next;
    }

    return count;
}

public int[] getServiceTimes() {

    int[] serviceTimes = new int[size()];

    QueueNode current = front;

    int index = 0;

    while (current != null) {

        serviceTimes[index] = current.student.getEstimatedServiceTime();

        index++;

        current = current.next;
    }

    return serviceTimes;
}

}