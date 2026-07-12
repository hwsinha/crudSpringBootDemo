package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
