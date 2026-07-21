package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }
    //read student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id) {
            Student studentResp = studentService.getStudent(id);
            if(studentResp == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
            List<Student> studentList = studentService.getAllStudent();
            if(studentList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentList);
    }

    //update student
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id, studentReq);
        if(studentResp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    //delete student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Boolean isDeleted =studentService.deleteStudent(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftly(@RequestParam Long id) {
        Boolean isDeleted= studentService.deleteSoftlyStudent(id);
        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }


}
