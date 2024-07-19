package com.yussuf.online_student.services;

import com.yussuf.online_student.model.Student;
import com.yussuf.online_student.repositories.StudentRepository;
import com.yussuf.online_student.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}
