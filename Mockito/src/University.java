import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<Department> departmentList;
    private final List<Course> courseList;
    private final List<Student> studentList;
    private final List<Professor> professorList;

    public University() {
        this.courseList = new ArrayList<>();
        this.departmentList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.professorList = new ArrayList<>();
    }

    public void  addDepartment(Department department){
        departmentList.add(department);
    }

    public void  addCourse(Course course){
        courseList.add(course);
    }

    public void  addStudent(Student student){
        studentList.add(student);
    }

    public void  addProfessor(Professor professor){
        professorList.add(professor);
    }

    public void assignProfessorToDepartment(Professor professor, Department department){
        professorList.add(professor);
        departmentList.add(department);
    }

    public void assignCourseToDepartment(Course course, Department department){
        courseList.add(course);
        departmentList.add(department);
    }

    public void assignProfessorToCourse(Professor professor, Course course){
        professorList.add(professor);
        courseList.add(course);
    }

    public List<Course> searchCourseByProfessor(Professor professor){
       return  professor.getCourseList();
    }

    public List<Course> searchCourseByStudent(Student student){
        return student.getCourseList();
    }

    public List<Professor> searchProfessorByCourse(Course course){
        return course.getProfessorList();
    }

    public List<Student> searchStudentByCourse(Course course){
        return course.getStudentList();
    }

}
