package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student create(Student student) {
        return repository.save(student);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Optional<Student> getById(Long studentId) {
        return repository.findById(studentId);
    }

    public void update(Long studentId, Student student) {
        Optional<Student> studentToUpdate = getById(studentId);

        studentToUpdate.get().setName(student.getName());
        studentToUpdate.get().setEmail(student.getEmail());
        studentToUpdate.get().setAge(student.getAge());

        repository.save(studentToUpdate.get());
    }

    public void delete(Long studentId) {
        repository.deleteById(studentId);
    }
}
