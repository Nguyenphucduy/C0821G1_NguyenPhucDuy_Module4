package librarybook.borrowbooks.service.impl;

import librarybook.borrowbooks.model.CodeBook;
import librarybook.borrowbooks.repository.ICodeBookRepository;
import librarybook.borrowbooks.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBookService implements ICodeBookService {
    @Autowired
    ICodeBookRepository iCodeBookRepository;

    @Override
    public void save(CodeBook codeBook) {
        iCodeBookRepository.save(codeBook);
    }

    @Override
    public List<CodeBook> findAll() {
        return iCodeBookRepository.findAll();
    }

    @Override
    public void delete(CodeBook codeBook) {
        iCodeBookRepository.delete(codeBook);
    }


}
