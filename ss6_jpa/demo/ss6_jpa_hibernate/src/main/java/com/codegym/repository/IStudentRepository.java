package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where name like :name",nativeQuery = true)
    List<Student> getByName(@Param("name")String name);
}
