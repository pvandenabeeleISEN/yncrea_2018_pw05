package yncrea.pw05.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String lastname;

    private String firstname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Course> courses;


    public Student() {
    }


    public Student(final String lastname, final String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }


    public long getId() {
        return id;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(final String lastnameValue) {
        lastname = lastnameValue;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(final String firstnameValue) {
        firstname = firstnameValue;
    }


    public List<Course> getCourses() {
        return courses;
    }


    public void setCourses(final List<Course> coursesValue) {
        courses = coursesValue;
    }
}
