package interview.student.repositories;

import org.springframework.data.repository.CrudRepository;

import interview.student.models.StudentSubject;

public interface StudentSubjectRepository extends CrudRepository<StudentSubject, Integer> {
    long countBySubjectId(Integer subjectId);

}