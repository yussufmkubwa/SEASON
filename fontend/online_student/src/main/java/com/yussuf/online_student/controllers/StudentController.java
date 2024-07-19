package com.yussuf.online_student.controllers;

import com.yussuf.online_student.model.Student;
import com.yussuf.online_student.model.Users;
import com.yussuf.online_student.services.StudentService;
import com.yussuf.online_student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student saveStudents = studentService.saveStudent(student);
        return new ResponseEntity<>(saveStudents, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable("id") Long id, @RequestBody Student student) {
        Optional<Student> existingUser = studentService.getStudentById(id);
        if (existingUser.isPresent()) {
            student.setId(id);
            Student updatedUser = studentService.updateStudent(student);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Optional<Student> existingUser = studentService.getStudentById(id);
        if (existingUser.isPresent()) {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
