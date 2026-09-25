public class Student {

    // Student information
    private String studentNo;
    private String name;
    private String serviceType;
    private int serviceTime;

    // Constructor
    public Student(String studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    // Getters
    public String getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    // Display student information
    public void displayStudent() {
        System.out.printf("%-12s %-15s %-20s %-10d%n",
                studentNo, name, serviceType, serviceTime);
    }
}