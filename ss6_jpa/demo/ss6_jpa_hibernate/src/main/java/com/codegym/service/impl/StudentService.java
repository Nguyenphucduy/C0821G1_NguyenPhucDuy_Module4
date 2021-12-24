package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Value dùng để xác định tên bean được tạo -> hỗ trợ cho @Qualifier.
@Service(value = "studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return
                iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        //Thêm mới và cập nhật đều dùng save.
        // Nhưng nếu student không có id thì thêm mới -> có id tồn tại trong DB thì sẽ thành cập nhật
        iStudentRepository.save(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepository.getByName("%"+name+"%");
    }
}
