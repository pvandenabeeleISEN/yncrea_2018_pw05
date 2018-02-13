package yncrea.pw05.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yncrea.pw05.contract.dto.StudentDTO;
import yncrea.pw05.contract.facade.StudentWS;
import yncrea.pw05.core.entity.Student;
import yncrea.pw05.core.service.StudentService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Named("studentWS")
@WebService(endpointInterface = "yncrea.pw05.contract.facade.StudentWS")
public class StudentWSImpl implements StudentWS {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWSImpl.class);

    @Inject
    private StudentService studentService;

    @Override
    public List<StudentDTO> getAllStudents() {
        LOGGER.info("return all the students, fetched from the DB");
        final List<Student> all = studentService.findAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for(Student student:all){
            dtos.add(new StudentDTO(student.getLastname(),student.getFirstname()));
        }
        return dtos;
    }


    @Override
    public void saveStudent(final StudentDTO studentDTO) {
        LOGGER.info("save a student sent from the WS");
        studentService.saveStudent(new Student(studentDTO.getLastname(),studentDTO.getFirstname()));
    }
}
