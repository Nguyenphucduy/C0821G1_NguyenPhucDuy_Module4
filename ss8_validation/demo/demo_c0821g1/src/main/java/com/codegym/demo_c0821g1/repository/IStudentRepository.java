package com.codegym.demo_c0821g1.repository;

import com.codegym.demo_c0821g1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iStudentRepository")
public interface IStudentRepository extends JpaRepository<Student, Integer> {
//    nativeQuery = true - > SQL , false -> HQL
    @Query(value = "select * from student where name like :name",nativeQuery = true)
    List<Student> getByName(@Param("name") String name);
}
