package furama.furama.service.furama.contract.attach_service.impl;

import furama.furama.model.contract.AttachService;
import furama.furama.repository.contract.IAttachServiceRepository;
import furama.furama.service.furama.contract.attach_service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachService {
    @Autowired
    IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public List<AttachService> findAttachService() {
        return iAttachServiceRepository.findAttachService();
    }
}
