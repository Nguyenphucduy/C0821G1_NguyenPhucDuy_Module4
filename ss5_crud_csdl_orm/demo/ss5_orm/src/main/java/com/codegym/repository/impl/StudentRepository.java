package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> getAll() {
        List<Student> list = BaseRepository.entityManager
                .createQuery("select s from student s where s.name = ?1" , Student.class)
                .setParameter(1,"HaiTT")
                .getResultList();
//        HQL
        return list;
    }

    @Override
    public Student findById(Integer id) {
      return BaseRepository.entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
