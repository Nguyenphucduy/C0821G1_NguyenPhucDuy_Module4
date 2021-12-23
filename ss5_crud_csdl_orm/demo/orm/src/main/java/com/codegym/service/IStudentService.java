package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAll();

    Student findById(Integer id);

    void save(Student student);
}
