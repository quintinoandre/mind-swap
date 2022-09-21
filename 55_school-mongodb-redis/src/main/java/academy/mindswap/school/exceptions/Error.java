package academy.mindswap.school.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Error {
    private Date timestamp;
    private String message;
    private String method;
    private String path;
}
