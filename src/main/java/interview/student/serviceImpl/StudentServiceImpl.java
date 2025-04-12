package interview.student.serviceImpl;

import org.springframework.stereotype.Service;

import interview.student.dtos.request.AssignSubjectRequestDto;
import interview.student.dtos.request.CreateStudentRequestDto;
import interview.student.dtos.request.UpdateStudentRequestDto;
import interview.student.dtos.response.AssignSubjectResponseDto;
import interview.student.dtos.response.CreateStudentResponseData;
import interview.student.dtos.response.UpdateStudentResponseData;
import interview.student.models.Student;
import interview.student.models.StudentSubject;
import interview.student.models.Subject;
import interview.student.repositories.StudentRepository;
import interview.student.repositories.StudentSubjectRepository;
import interview.student.repositories.SubjectRepository;
import interview.student.services.StudentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentSubjectRepository studentSubjectRepository;

    @Override
    public CreateStudentResponseData createStudent(CreateStudentRequestDto studentRequestDto) throws Exception {
        Student student = Student.builder()
                .age(studentRequestDto.getAge())
                .name(studentRequestDto.getName())
                .rollNo(studentRequestDto.getRollNo())
                .build();

        Student savedStudent = studentRepository.save(student);
        CreateStudentResponseData result = CreateStudentResponseData.builder().studentId(savedStudent.getId()).build();

        return result;
    }

    @Override
    public UpdateStudentResponseData updateStudent(String studentId, UpdateStudentRequestDto updateStudentRequestDto)
            throws Exception {
        Student student = studentRepository.findById(Integer.parseInt(studentId))
                .orElseThrow(() -> new RuntimeException("user not found"));

        if (updateStudentRequestDto.getAge() != null) {
            student.setAge(updateStudentRequestDto.getAge());
        }
        if (updateStudentRequestDto.getName() != null) {
            student.setName(updateStudentRequestDto.getName());
        }
        if (updateStudentRequestDto.getRollNo() != null) {
            student.setRollNo(updateStudentRequestDto.getRollNo());
        }

        studentRepository.save(student);
        UpdateStudentResponseData result = UpdateStudentResponseData.builder().studentId(Integer.parseInt(studentId))
                .build();

        return result;
    };

    @Override
    public AssignSubjectResponseDto assignSubject(AssignSubjectRequestDto assignSubjectDto) throws Exception {

        Student student = studentRepository
                .findById(assignSubjectDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("No student found"));

        Subject subject = subjectRepository
                .findById(assignSubjectDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("No subject found"));

        StudentSubject assignSubject = StudentSubject
                .builder()
                .student(student)
                .subject(subject)
                .build();

        StudentSubject createdAssignedSubject = studentSubjectRepository.save(assignSubject);

        return AssignSubjectResponseDto.builder().id(createdAssignedSubject.getId()).build();
    }
}
