import java.util.ArrayList;
import java.util.List;

public class Student {

    private int studentId;
    private String studentName;
    private List<Course> courseList;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseList = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void enrollCourse(Course course){
        courseList.add(course);
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
