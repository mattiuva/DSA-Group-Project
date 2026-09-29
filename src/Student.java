public class Student {

    private String studentNumber;
    private String name;
    private String serviceType;
    private int estimatedServiceTime;

    public Student(String studentNumber, String name, String serviceType, int estimatedServiceTime) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedServiceTime = estimatedServiceTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentNo() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getEstimatedServiceTime() {
        return estimatedServiceTime;
    }

    public int getServiceTime() {
        return estimatedServiceTime;
    }

    public void displayStudent() {
        System.out.printf("%-12s %-15s %-20s %-10d%n",
                studentNumber, name, serviceType, estimatedServiceTime);
    }
}