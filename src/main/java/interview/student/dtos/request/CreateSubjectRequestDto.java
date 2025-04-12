package interview.student.dtos.request;

import interview.student.enums.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRequestDto {

    private String name;

    private Branch branch;
}
