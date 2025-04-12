package interview.student.services;

import interview.student.dtos.request.CreateSubjectRequestDto;
import interview.student.dtos.response.CreateSubjectResponseData;
import interview.student.dtos.response.DeleteSubjectResponseData;

public interface SubjectService {
    public CreateSubjectResponseData addSubject(CreateSubjectRequestDto createSubjectDto) throws Exception;

    public DeleteSubjectResponseData deleteSubject(String subjectId) throws Exception;
}
