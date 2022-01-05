package com.codegym.demo.repository;


import com.codegym.demo.model.PersonalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCodeRepository extends JpaRepository<PersonalCode,Integer> {
    PersonalCode findByCodeForBook(String code);
}
