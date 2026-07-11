package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class StudentRepository {

    public Student saveStudent( Student studentReq) {
        //save to db
        System.out.println("Inside StudentRepository saveStudent");
        System.out.println("Exiting StudentRepository saveStudent");
        Student s1= new Student();
        s1.setName("aditya");
        s1.setAge(30);
        s1.setEmail("adi@gmail.com");
        s1.setRollNo(101);
        s1.setSubject("spring");
        return s1;
    }
}
