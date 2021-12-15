package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Value dùng để xác định tên bean được tạo -> hỗ trợ cho @Qualifier.
@Service(value = "studentService")
public class StudentService implements IStudentService {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1,"haiTT","1/1/1998",1,7.0));
        students.add(new Student(1,"haiTT","1/1/1998",1,7.0));
        students.add(new Student(1,"haiTT","1/1/1998",1,7.0));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}
