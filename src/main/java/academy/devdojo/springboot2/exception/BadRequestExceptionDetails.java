package academy.devdojo.springboot2.exception;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;


}
