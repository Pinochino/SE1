import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private Department department;
    private List<Professor> professorList;
    private List<Student> studentList;
    private int year;

    public Course(String courseName, Department department, int year) {
        this.courseName = courseName;
        this.department = department;
        this.year = year;
        this.professorList = new ArrayList<>();
        this.studentList = new ArrayList<>();
    }

    public void addProfessor(Professor professor){
        professorList.add(professor);
    }

    public void enrollStudent(Student student){
        studentList.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
