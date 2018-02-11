package yncrea.pw05.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private Course course;

    private int grade;


    public Work() {
    }


    public Work(final String name, final int grade, final Course course) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(final Course courseValue) {
        course = courseValue;
    }


    public int getGrade() {
        return grade;
    }


    public void setGrade(final int gradeValue) {
        grade = gradeValue;
    }
}
