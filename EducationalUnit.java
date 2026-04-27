package composite;

/**
 * Component Interface - EducationalUnit
 * The base interface for all educational entities in the Composite Design Pattern.
 * Both leaf nodes (Teacher, Student) and composite nodes (College, Department)
 * implement this interface, enabling uniform treatment.
 */
public interface EducationalUnit {

    /**
     * Displays the details of the educational unit.
     * @param indent used for hierarchical indentation in display
     */
    void displayDetails(String indent);

    /**
     * Returns the total number of students within this unit
     * (including those in sub-units for composites).
     */
    int getStudentCount();

    /**
     * Returns the budget of this unit.
     * - Teacher: salary (positive)
     * - Student: negative tuition fee
     * - Department/College: sum of children budgets
     */
    double getBudget();

    /**
     * Returns the name of the educational unit.
     */
    String getName();
}
