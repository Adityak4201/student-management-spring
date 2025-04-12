package interview.student.dtos.request;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignSubjectRequestDto {
    @NonNull
    private Integer studentId;

    @NonNull
    private Integer subjectId;
}
