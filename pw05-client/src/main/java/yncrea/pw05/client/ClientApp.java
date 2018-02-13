package yncrea.pw05.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yncrea.pw05.contract.dto.StudentDTO;
import yncrea.pw05.contract.facade.StudentWS;

import java.util.List;

public class ClientApp {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("yncrea.pw05.client.config");
        final StudentWS studentWS = context.getBean(StudentWS.class);
        studentWS.saveStudent(new StudentDTO("AWESOME","Student"));
        final List<StudentDTO> allStudents = studentWS.getAllStudents();
        allStudents.forEach(System.out::println);
    }

}
