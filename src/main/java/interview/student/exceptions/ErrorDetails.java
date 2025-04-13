package interview.student.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class ErrorDetails {
    private String message;
    private Map<String, String> errors;
}
