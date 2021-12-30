package librarybook.borrowbooks.service;

import librarybook.borrowbooks.model.CodeBook;

import java.util.List;

public interface ICodeBookService {
    void save(CodeBook codeBook);

    List<CodeBook> findAll();

    void delete(CodeBook codeBook);
}
