package academy.mindswap.school.exceptions.teachers;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.teachers.TeacherExceptionMessages.TEACHER_NOT_FOUND;

public class TeacherNotFoundException extends NotFoundException {
    public TeacherNotFoundException() {
        super(TEACHER_NOT_FOUND);
    }
}
