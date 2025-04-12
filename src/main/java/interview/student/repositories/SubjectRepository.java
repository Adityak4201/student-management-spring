package interview.student.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import interview.student.models.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}