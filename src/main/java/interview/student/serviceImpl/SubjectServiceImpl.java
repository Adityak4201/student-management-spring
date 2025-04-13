package interview.student.serviceImpl;

import org.springframework.stereotype.Service;

import interview.student.dtos.request.CreateSubjectRequestDto;
import interview.student.dtos.response.CreateSubjectResponseData;
import interview.student.dtos.response.DeleteSubjectResponseData;
import interview.student.models.Subject;
import interview.student.repositories.StudentSubjectRepository;
import interview.student.repositories.SubjectRepository;
import interview.student.services.SubjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentSubjectRepository studentSubjectRepository;

    @Override
    public CreateSubjectResponseData addSubject(CreateSubjectRequestDto addSubjectDto) throws Exception {
        Subject subjectEntity = Subject.builder()
                .name(addSubjectDto.getName())
                .branch(addSubjectDto.getBranch())
                .build();

        Subject subject = subjectRepository.save(subjectEntity);
        CreateSubjectResponseData result = CreateSubjectResponseData.builder().subjectId(subject.getId()).build();

        return result;
    }

    @Override
    public DeleteSubjectResponseData deleteSubject(String subjectId) throws Exception {

        long studentsAssigned = studentSubjectRepository.countBySubjectId(Integer.parseInt(subjectId));

        if (studentsAssigned > 0) {
            throw new IllegalStateException("Subject has already been assigned to students");
        }

        if (!subjectRepository.existsById(Integer.parseInt(subjectId))) {
            throw new EntityNotFoundException("Subject not found");
        }

        subjectRepository.deleteById(Integer.parseInt(subjectId));

        return DeleteSubjectResponseData.builder().subjectId(Integer.parseInt(subjectId)).build();
    }
}
