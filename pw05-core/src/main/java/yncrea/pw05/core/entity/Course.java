package yncrea.pw05.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean validated;

    private String name;

    @ManyToOne
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course",fetch = FetchType.EAGER)
    private List<Work> works;


    public Course() {
    }


    public Course(final String name, final Student student) {
        this.name = name;
        this.student = student;
    }


    public long getId() {
        return id;
    }


    public boolean isValidated() {
        return validated;
    }


    public void setValidated(final boolean validatedValue) {
        validated = validatedValue;
    }


    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public Student getStudent() {
        return student;
    }


    public void setStudent(final Student studentValue) {
        student = studentValue;
    }


    public List<Work> getWorks() {
        return works;
    }


    public void setWorks(final List<Work> worksValue) {
        works = worksValue;
    }
}
