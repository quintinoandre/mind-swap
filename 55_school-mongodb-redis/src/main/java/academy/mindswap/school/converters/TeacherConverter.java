package academy.mindswap.school.converters;

import academy.mindswap.school.commands.teacher.SaveTeacherDto;
import academy.mindswap.school.commands.teacher.TeacherDto;
import academy.mindswap.school.commands.teacher.UpdateTeacherDto;
import academy.mindswap.school.models.Teacher;

public final class TeacherConverter {
    private TeacherConverter() {
    }

    public static TeacherDto convertToDto(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .email(teacher.getEmail())
                .dateOfBirth(teacher.getDateOfBirth())
                .cars(teacher.getCars())
                .roles(teacher.getRoles())
                .build();
    }

    public static Teacher convertSaveTeacherDtoToEntity(SaveTeacherDto saveTeacherDto) {
        return Teacher.builder()
                .name(saveTeacherDto.getName())
                .email(saveTeacherDto.getEmail())
                .password(saveTeacherDto.getPassword())
                .dateOfBirth(saveTeacherDto.getDateOfBirth())
                .cars(saveTeacherDto.getCars())
                .roles(saveTeacherDto.getRoles())
                .build();
    }

    public static Teacher convertUpdateTeacherDtoToEntity(UpdateTeacherDto updateTeacherDto) {
        return Teacher.builder()
                .name(updateTeacherDto.getName())
                .email(updateTeacherDto.getEmail())
                .password(updateTeacherDto.getPassword())
                .dateOfBirth(updateTeacherDto.getDateOfBirth())
                .cars(updateTeacherDto.getCars())
                .roles(updateTeacherDto.getRoles())
                .build();
    }
}
