package composite;

/**
 * Leaf - Student
 * Represents an individual student. Cannot contain other units.
 * Budget = negative tuition fee (cost to the institution).
 */
public class Student implements EducationalUnit {

    private String name;
    private String studentId;
    private double tuitionFee;

    public Student(String name, String studentId, double tuitionFee) {
        this.name = name;
        this.studentId = studentId;
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "[Student]");
        System.out.println(indent + "  Name        : " + name);
        System.out.println(indent + "  Student ID  : " + studentId);
        System.out.printf(indent + "  Tuition Fee : PHP %.2f%n", tuitionFee);
    }

    @Override
    public int getStudentCount() {
        // Each student counts as 1
        return 1;
    }

    @Override
    public double getBudget() {
        // Students represent a cost (negative budget contribution)
        return -tuitionFee;
    }
}
