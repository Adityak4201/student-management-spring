package interview.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import interview.student.models.StudentSubject;

public interface StudentSubjectRepository extends CrudRepository<StudentSubject, Integer> {
    List<StudentSubject> findBySubjectId(Integer subjectId);
}