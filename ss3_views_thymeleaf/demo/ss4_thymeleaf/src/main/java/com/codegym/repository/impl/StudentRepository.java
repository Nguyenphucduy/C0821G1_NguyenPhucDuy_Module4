package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "haiTT", "1/1/1998", 1, 7.0));
        students.add(new Student(2, "trungDP", "1/1/1998", 1, 7.0));
        students.add(new Student(3, "TrungDC", "1/1/1998", 1, 7.0));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student findById(Integer id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
}
