package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite - College
 * Represents a high-level organizational unit.
 * Can contain Departments, Teachers, Students, and even other Colleges.
 * Budget = sum of all children budgets (salaries minus tuition fees).
 */
public class College implements EducationalUnit {

    private String name;
    private List<EducationalUnit> units = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds any educational unit (College, Department, Teacher, Student).
     */
    public void add(EducationalUnit unit) {
        units.add(unit);
    }

    /**
     * Removes an educational unit from this college.
     */
    public void remove(EducationalUnit unit) {
        units.remove(unit);
    }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "=================================");
        System.out.println(indent + "  [College] " + name);
        System.out.println(indent + "=================================");
        if (units.isEmpty()) {
            System.out.println(indent + "  (No units)");
        } else {
            for (EducationalUnit unit : units) {
                unit.displayDetails(indent + "  ");
            }
        }
        System.out.println(indent + "---------------------------------");
        System.out.printf(indent + "  Total Budget        : PHP %.2f%n", getBudget());
        System.out.println(indent + "  Total Student Count : " + getStudentCount());
        System.out.println(indent + "=================================");
    }

    @Override
    public int getStudentCount() {
        int count = 0;
        for (EducationalUnit unit : units) {
            count += unit.getStudentCount();
        }
        return count;
    }

    @Override
    public double getBudget() {
        double total = 0;
        for (EducationalUnit unit : units) {
            total += unit.getBudget();
        }
        return total;
    }
}
