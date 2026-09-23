public static void main(String[] args) {

    Queue queue = new Queue();

    Student student1 = new Student("221045678", "Maria", "Registration", 12);
    Student student2 = new Student("222034512", "Tomas", "Student Card", 5);
    Student student3 = new Student("223041876", "Ndapewa", "Fees", 8);
    Student student4 = new Student("221067341", "Simon", "Documents", 4);
    Student student5 = new Student("221078945", "Petrus", "Academic Enquiry", 15);
    Student student6 = new Student("222089456", "Anna", "Registration", 7);

    queue.enqueue(student1);
    queue.enqueue(student2);
    queue.enqueue(student3);
    queue.enqueue(student4);
    queue.enqueue(student5);
    queue.enqueue(student6);

    System.out.println("=== Students Waiting in Queue ===");
    queue.displayQueue();

    System.out.println("Next student: " + queue.peek().getName());

    Student servedStudent1 = queue.dequeue();
    System.out.println("Served student: " + servedStudent1.getName());

    Student servedStudent2 = queue.dequeue();
    System.out.println("Served student: " + servedStudent2.getName());

    Student servedStudent3 = queue.dequeue();
    System.out.println("Served student: " + servedStudent3.getName());

    System.out.println();
    System.out.println("=== Queue After Serving 3 Students ===");
    queue.displayQueue();
}