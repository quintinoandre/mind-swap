package academy.mindswap.school.commands.teacher;

import academy.mindswap.school.builders.TeacherBuilder;
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
                .age(teacher.getAge())
                //.carsDtos(teacher.getCars().stream().map(CarConverter::convertToDto).toList())
                //.shopsDtos(teacher.getShops().stream().map(ShopConverter::convertToDto).toList())
                //.rolesDtos(teacher.getRoles().stream().map(ShopConverter::convertToDto).toList())
                .build();
    }

    public static Teacher convertSaveTeacherDtoToEntity(SaveTeacherDto saveTeacherDto) {
        return TeacherBuilder.builder()
                .name(saveTeacherDto.getName())
                .email(saveTeacherDto.getEmail())
                .password(saveTeacherDto.getPassword())
                .dateOfBirth(saveTeacherDto.getDateOfBirth())
                .build();
    }
}
