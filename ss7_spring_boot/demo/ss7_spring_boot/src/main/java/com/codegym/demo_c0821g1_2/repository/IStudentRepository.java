package com.codegym.demo_c0821g1_2.repository;

import com.codegym.demo_c0821g1_2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "iStudentRepository")
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where name like :name",nativeQuery = true)
    List<Student> getByName(@Param("name") String name);
}
