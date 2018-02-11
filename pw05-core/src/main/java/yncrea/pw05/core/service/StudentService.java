package yncrea.pw05.core.service;

import yncrea.pw05.core.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findByLastname(String lastname);

    void saveStudent(Student student);

    List<Student> findAll();

    List<Student> findAllWithCourses();

    void deleteStudent(long id);
}
