import java.util.*;

// This class represents a grading (Zeugnis) with matriculationID, name of the course, grade and
// the date (as a string) when the grading was issued.
public class Grading {
    private final int matriculationID;
    private final String course;
    private final int grade;
    private final String issueDate;

    // Initializes this 'Grading'.
    public Grading(int matriculationID, String course, int grade, String issueDate) {
        this.matriculationID = matriculationID;
        this.course = course;
        this.grade = grade;
        this.issueDate = issueDate;
    }

    public int getMatriculationID() {
        return matriculationID;
    }

    @Override
    public String toString() {
        return "Matrikel#: " + matriculationID  + ", LV: " + course + ", Note: " + grade + ", Datum: " + issueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grading grading = (Grading) o;
        return matriculationID == grading.matriculationID && grade == grading.grade &&
                course.equals(grading.course) && issueDate.equals(grading.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculationID, course, grade, issueDate);
    }
}