package academy.mindswap.school.exceptions.teachers;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.TEACHERS_NOT_FOUND;

public class TeachersNotFoundException extends NotFoundException {
    public TeachersNotFoundException() {
        super(TEACHERS_NOT_FOUND);
    }
}
