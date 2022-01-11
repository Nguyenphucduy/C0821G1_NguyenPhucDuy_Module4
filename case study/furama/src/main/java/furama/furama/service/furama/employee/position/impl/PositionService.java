package furama.furama.service.furama.employee.position.impl;

import furama.furama.model.employee.Position;
import furama.furama.repository.employee.IPositionRepository;
import furama.furama.service.furama.employee.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
