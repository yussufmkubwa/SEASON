package com.yussuf.online_student.controllers;


import com.yussuf.online_student.model.Course;
import com.yussuf.online_student.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> createEmployee(@RequestBody Course course) {
        Course saveCourse = courseService.saveCourse(course);
        return new ResponseEntity<>(saveCourse, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> Course = courseService.getAllCourses();
        return new ResponseEntity<>(Course, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        Optional<Course> Course = courseService.getCourseById(id);
        return Course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) {
        Optional<Course> existingCourse = courseService.getCourseById(id);
        if (existingCourse.isPresent()) {
            course.setId(id);
            Course updatedCourse = courseService.saveCourse(course);
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Optional<Course> existingCourse = courseService.getCourseById(id);
        if (existingCourse.isPresent()) {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
