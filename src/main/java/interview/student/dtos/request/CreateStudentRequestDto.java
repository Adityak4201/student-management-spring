package interview.student.dtos.request;

import lombok.Data;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequestDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String rollNo;

    @NonNull
    private Integer age;
}
