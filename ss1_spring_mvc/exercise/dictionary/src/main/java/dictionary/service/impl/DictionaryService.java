package dictionary.service.impl;

import dictionary.entity.Dictionary;
import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//@Service(value = "DictionaryService")
@Service
public class DictionaryService implements IDictionaryService {
    private static List<Dictionary> dictionaries = new ArrayList<>();
    static {
        dictionaries.add(new Dictionary("Word","Từ"));
        dictionaries.add(new Dictionary("Good Bye","Tạm Biệt"));
        dictionaries.add(new Dictionary("Hello","Xin Chào"));
    }

    @Override
    public List<Dictionary> getAll() {
        return dictionaries;
    }
}
