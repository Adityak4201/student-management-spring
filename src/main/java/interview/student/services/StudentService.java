package interview.student.services;

import interview.student.dtos.request.CreateStudentRequestDto;
import interview.student.dtos.request.UpdateStudentRequestDto;
import interview.student.dtos.response.CreateStudentResponseData;
import interview.student.dtos.response.UpdateStudentResponseData;

public interface StudentService {
    public CreateStudentResponseData createStudent(CreateStudentRequestDto studentRequestDto) throws Exception;

    public UpdateStudentResponseData updateStudent(String studentId, UpdateStudentRequestDto updateStudentRequestDto)
            throws Exception;
}
