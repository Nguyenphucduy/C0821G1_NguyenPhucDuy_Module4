package furama.furama.service.furama.contract.attach_service;

import furama.furama.model.contract.AttachService;

import java.util.List;

public interface IAttachService {
    List<AttachService> findAll();

    List<AttachService> findAttachService();
}
