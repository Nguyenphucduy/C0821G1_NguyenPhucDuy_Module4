package dictionary.service;

import dictionary.bean.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IDictionaryService {
    List<Dictionary> getAll();
}
