package storage;

import model.Student;

import java.util.List;

public interface IReadAndWrite {
    void writeFileStudent(List<Student> students);

    List<Student> readFileStudent();
}
