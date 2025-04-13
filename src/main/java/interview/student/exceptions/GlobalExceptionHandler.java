package interview.student.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        List<Throwable> exlist = new ArrayList<>();
        StringBuilder errors = new StringBuilder();
        Throwable throwable = ex.getCause();
        if (throwable == null || throwable.getCause() == null) {
            errors.append(ex.getMessage());
            ;
        } else {
            while (throwable != null && exlist.size() < 4) {
                if (throwable.getCause() == null) {
                    exlist.add(throwable.getCause());
                    throwable = throwable.getCause();
                } else {
                    errors.append(throwable.getMessage());
                    break;
                }
            }
        }
        Map<String, String> errorMap = new HashMap<>();
        if (!errors.isEmpty()) {
            errorMap.put("error", errors.toString());
        } else {
            errorMap.put("error", exlist.toString());
        }
        ErrorDetails errorDetails = new ErrorDetails(errors.toString(), errorMap);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
