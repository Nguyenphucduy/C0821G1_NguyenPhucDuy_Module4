package com.codegym.demo_c0821g1_2.service.impl;

import com.codegym.demo_c0821g1_2.model.Student;
import com.codegym.demo_c0821g1_2.repository.IStudentRepository;
import com.codegym.demo_c0821g1_2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

//Value dùng để xác định tên bean được tạo -> hỗ trợ cho @Qualifier.
@Service(value = "studentService")
public class StudentService implements IStudentService {
    @Autowired
    @Qualifier(value = "iStudentRepository")
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return iStudentRepository.findById(id).orElse(null);
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

    @Override
    public Page<Student> findAll(Pageable of) {
        return iStudentRepository.findAll(of);
    }
}
