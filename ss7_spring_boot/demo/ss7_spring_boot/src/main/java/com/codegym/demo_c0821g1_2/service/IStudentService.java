package com.codegym.demo_c0821g1_2.service;

import com.codegym.demo_c0821g1_2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {

    List<Student> getAll();

    Student findById(Integer id);

    void save(Student student);

    List<Student> findByName(String name);

    Page<Student> findAll(Pageable of);
}
