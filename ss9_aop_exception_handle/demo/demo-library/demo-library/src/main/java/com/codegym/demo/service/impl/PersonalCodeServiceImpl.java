package com.codegym.demo.service.impl;


import com.codegym.demo.model.PersonalCode;
import com.codegym.demo.repository.PersonalCodeRepository;
import com.codegym.demo.service.PersonalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCodeServiceImpl implements PersonalCodeService {
    @Autowired
    private PersonalCodeRepository personalCodeRepository;

    @Override
    public void save(PersonalCode personalCode) {
        personalCodeRepository.save(personalCode);
    }

    @Override
    public PersonalCode findById(Integer id) {
        return personalCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        personalCodeRepository.deleteById(id);
    }

    @Override
    public PersonalCode findByCode(String code) {
        return personalCodeRepository.findByCodeForBook(code);
    }
}
