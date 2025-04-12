package interview.student.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import interview.student.dtos.GenericResponse;
import interview.student.dtos.request.AssignSubjectRequestDto;
import interview.student.dtos.request.CreateStudentRequestDto;
import interview.student.dtos.request.UpdateStudentRequestDto;
import interview.student.dtos.response.AssignSubjectResponseDto;
import interview.student.dtos.response.CreateStudentResponseData;
import interview.student.dtos.response.UpdateStudentResponseData;
import interview.student.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("")
    @ResponseBody
    GenericResponse<CreateStudentResponseData> createStudent(
            @RequestBody @Valid CreateStudentRequestDto studentRequestDto)
            throws Exception {
        CreateStudentResponseData studentResponse = studentService.createStudent(studentRequestDto);
        return GenericResponse.<CreateStudentResponseData>builder()
                .message("Student created successfully")
                .data(studentResponse)
                .statusCode(HttpStatus.CREATED.value())
                .build();
    }

    @PatchMapping("/{studentId}")
    @ResponseBody
    GenericResponse<UpdateStudentResponseData> updateStudent(
            @PathVariable String studentId,
            @RequestBody @Valid UpdateStudentRequestDto updateStudentDto)
            throws Exception {
        UpdateStudentResponseData studentResponse = studentService.updateStudent(studentId, updateStudentDto);
        return GenericResponse.<UpdateStudentResponseData>builder()
                .message("Student updated successfully")
                .data(studentResponse)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @PostMapping("/subject/assign")
    @ResponseBody
    GenericResponse<AssignSubjectResponseDto> createStudent(
            @RequestBody @Valid AssignSubjectRequestDto assignSubjectDto)
            throws Exception {
        AssignSubjectResponseDto assignResponse = studentService.assignSubject(assignSubjectDto);
        return GenericResponse.<AssignSubjectResponseDto>builder()
                .message("Subject assigned successfully")
                .data(assignResponse)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

}
