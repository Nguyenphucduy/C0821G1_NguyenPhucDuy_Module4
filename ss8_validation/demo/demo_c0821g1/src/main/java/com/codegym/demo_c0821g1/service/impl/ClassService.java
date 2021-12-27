package com.codegym.demo_c0821g1.service.impl;

import com.codegym.demo_c0821g1.model.ClassRoom;
import com.codegym.demo_c0821g1.repository.IClassRepository;
import com.codegym.demo_c0821g1.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository iClassRepository;
    @Override
    public List<ClassRoom> findAll() {
        return iClassRepository.findAll();
    }
}
