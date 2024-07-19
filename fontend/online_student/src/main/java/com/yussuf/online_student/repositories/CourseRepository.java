package com.yussuf.online_student.repositories;

import com.yussuf.online_student.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
