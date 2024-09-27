import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private Professor inCharge;
    private List<Course> courses;
    private List<Professor> professors;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Professor getInCharge() {
        return inCharge;
    }

    public void setInCharge(Professor inCharge) {
        this.inCharge = inCharge;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void addProfessor(Professor professor){
        professors.add(professor);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
