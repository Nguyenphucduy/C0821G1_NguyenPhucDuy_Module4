package com.codegym.demo_c0821g1_2.repository;


import com.codegym.demo_c0821g1_2.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
