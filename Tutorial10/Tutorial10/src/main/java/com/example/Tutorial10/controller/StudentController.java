package com.example.Tutorial10.controller;

import com.example.Tutorial10.model.Student;
import com.example.Tutorial10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.suffix}/students")
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/detail/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't  find student by id: " + id));
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Long id){
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't find student by id:  " + id));
            studentRepository.delete(student);
        }
    }



}
