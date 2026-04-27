package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite - Department
 * Represents a department within a College.
 * Can contain Teachers and Students.
 * Budget = sum of teacher salaries - sum of student tuition fees.
 */
public class Department implements EducationalUnit {

    private String name;
    private List<EducationalUnit> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a teacher or student to this department.
     */
    public void add(EducationalUnit unit) {
        members.add(unit);
    }

    /**
     * Removes a unit from this department.
     */
    public void remove(EducationalUnit unit) {
        members.remove(unit);
    }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "+---------------------------------+");
        System.out.println(indent + "| [Department] " + name);
        System.out.println(indent + "+---------------------------------+");
        if (members.isEmpty()) {
            System.out.println(indent + "  (No members)");
        } else {
            for (EducationalUnit unit : members) {
                unit.displayDetails(indent + "  ");
            }
        }
        System.out.printf(indent + "  >> Department Budget : PHP %.2f%n", getBudget());
        System.out.println(indent + "  >> Student Count     : " + getStudentCount());
    }

    @Override
    public int getStudentCount() {
        int count = 0;
        for (EducationalUnit unit : members) {
            count += unit.getStudentCount();
        }
        return count;
    }

    @Override
    public double getBudget() {
        double total = 0;
        for (EducationalUnit unit : members) {
            total += unit.getBudget();
        }
        return total;
    }
}
