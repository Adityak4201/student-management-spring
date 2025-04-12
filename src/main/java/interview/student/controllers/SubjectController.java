package interview.student.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import interview.student.dtos.GenericResponse;
import interview.student.dtos.request.CreateSubjectRequestDto;
import interview.student.dtos.response.CreateSubjectResponseData;
import interview.student.dtos.response.DeleteSubjectResponseData;
import interview.student.services.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/subjects")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("")
    @ResponseBody
    GenericResponse<CreateSubjectResponseData> addSubject(
            @RequestBody @Valid CreateSubjectRequestDto addSubjectDto)
            throws Exception {
        CreateSubjectResponseData subjectResponse = subjectService.addSubject(addSubjectDto);
        return GenericResponse.<CreateSubjectResponseData>builder()
                .message("Subject added successfully")
                .data(subjectResponse)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @DeleteMapping("/{subjectId}")
    @ResponseBody
    GenericResponse<DeleteSubjectResponseData> updateStudent(@PathVariable String subjectId) throws Exception {
        DeleteSubjectResponseData response = subjectService.deleteSubject(subjectId);
        return GenericResponse.<DeleteSubjectResponseData>builder()
                .message("Subject deleted successfully")
                .data(response)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

}
