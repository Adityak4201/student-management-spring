package interview.student.repositories;

import org.springframework.data.repository.CrudRepository;

import interview.student.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
