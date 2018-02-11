package yncrea.pw05.core.service.impl;

import org.springframework.transaction.annotation.Transactional;
import yncrea.pw05.core.dao.StudentDAO;
import yncrea.pw05.core.entity.Student;
import yncrea.pw05.core.service.StudentService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDAO studentDAO;

    @Override
    public List<Student> findByLastname(final String lastname) {
       return studentDAO.findByLastname(lastname);
    }


    @Override
    public void saveStudent(final Student student) {
        studentDAO.save(student);
    }


    @Override
    public List<Student> findAllWithCourses() {
        return studentDAO.findAllWithCourses();
    }


    @Override
    public List<Student> findAll() {
       return studentDAO.findAll();
    }


    @Override
    public void deleteStudent(final long id) {
        studentDAO.delete(id);
    }
}
