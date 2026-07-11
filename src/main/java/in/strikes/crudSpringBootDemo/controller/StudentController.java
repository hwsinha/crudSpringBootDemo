package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside StudentController createStudent");
      Student createdStudent =  studentService.createStudent(student);
        System.out.println("Exiting StudentController createStudent");
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(createdStudent);
    }
    //read student

    //update student

    //delete student
}
