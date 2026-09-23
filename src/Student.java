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

public String getName() {
    return name;
}

public String getServiceType() {
    return serviceType;
}

public int getEstimatedServiceTime() {
    return estimatedServiceTime;
}

}