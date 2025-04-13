package interview.student.services;

import interview.student.dtos.request.AssignSubjectRequestDto;
import interview.student.dtos.request.CreateStudentRequestDto;
import interview.student.dtos.request.UpdateStudentRequestDto;
import interview.student.dtos.response.AssignSubjectResponseDto;
import interview.student.dtos.response.CreateStudentResponseData;
import interview.student.dtos.response.UpdateStudentResponseData;
import interview.student.models.Student;

public interface StudentService {
    public CreateStudentResponseData createStudent(CreateStudentRequestDto studentRequestDto) throws Exception;

    public UpdateStudentResponseData updateStudent(String studentId, UpdateStudentRequestDto updateStudentRequestDto)
            throws Exception;

    public AssignSubjectResponseDto assignSubject(AssignSubjectRequestDto assignSubjectDto) throws Exception;

    public Iterable<Student> getStudents() throws Exception;

}
