package academy.mindswap.school.builders;

import academy.mindswap.school.models.Shop;
import academy.mindswap.school.models.Teacher;

import java.time.LocalDate;
import java.util.List;

public final class TeacherBuilder {
    private final Teacher teacher;

    private TeacherBuilder() {
        this.teacher = new Teacher();
    }

    public static TeacherBuilder builder() {
        return new TeacherBuilder();
    }

    public TeacherBuilder id(Long id) {
        teacher.setId(id);
        return this;
    }

    public TeacherBuilder name(String name) {
        teacher.setName(name);
        return this;
    }

    public TeacherBuilder email(String email) {
        teacher.setEmail(email);
        return this;
    }

    public TeacherBuilder password(String password) {
        teacher.setPassword(password);
        return this;
    }

    public TeacherBuilder dateOfBirth(LocalDate dateOfBirth) {
        teacher.setDateOfBirth(dateOfBirth);
        return this;
    }

    public TeacherBuilder shops(List<Shop> shops) {
        teacher.setShops(shops);
        return this;
    }

    public Teacher build() {
        return teacher;
    }
}
