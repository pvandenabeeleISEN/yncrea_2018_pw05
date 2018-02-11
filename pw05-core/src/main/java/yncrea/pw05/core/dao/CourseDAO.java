package yncrea.pw05.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.pw05.core.entity.Course;

public interface CourseDAO extends JpaRepository<Course,Long> {

}
