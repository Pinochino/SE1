import java.util.ArrayList;
import java.util.List;

public class Professor {

    private String name;
    private String employeeId;
    private List<Department> departmentList;
    private List<Course> courseList;

    public Professor(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        this.departmentList = new ArrayList<>();
        this.courseList = new ArrayList<>();
    }

    public void addDepartment(Department department){
        departmentList.add(department);
    }

    public void assignToCourse(Course course){
        courseList.add(course);
    }

    public void assignToDepartment(Department department){
        departmentList.add(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
