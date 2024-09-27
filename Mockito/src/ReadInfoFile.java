import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInfoFile {
    public static List<Department> readDepartmentsFromFile(String fileName){
        List<Department> departmentList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(fileName);
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return departmentList;
    }

    public static List<Professor> readProfessorsFromFile(String fileName){
        List<Professor> professorList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(fileName);
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return professorList;
    }

    public static List<Course> readCoursesFromFile(String fileName){
        List<Course> courseList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(fileName);
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return courseList;
    }

    public static List<Student> readStudentsFromFile(String fileName){
        List<Student> studentList = new ArrayList<>();
        try{
            Scanner sc = new Scanner(fileName);
            while (sc.hasNext()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return studentList;
    }

}
