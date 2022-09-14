package academy.mindswap.school.exceptions.teachers;

import academy.mindswap.school.exceptions.BadRequestException;

public class TeacherBadRequestException extends BadRequestException {
    public TeacherBadRequestException(String message) {
        super(message);
    }
}
