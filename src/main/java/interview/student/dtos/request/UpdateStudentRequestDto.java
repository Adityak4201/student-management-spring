package interview.student.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class UpdateStudentRequestDto {
    private String name;

    private String rollNo;

    private Integer age;
}
