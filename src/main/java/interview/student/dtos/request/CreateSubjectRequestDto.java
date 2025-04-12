package interview.student.dtos.request;

import interview.student.enums.Branch;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRequestDto {

    @NotEmpty
    private String name;

    private Branch branch;
}
