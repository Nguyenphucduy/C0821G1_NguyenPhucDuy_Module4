package librarybook.borrowbooks.repository;

import librarybook.borrowbooks.model.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook,Integer> {
}
