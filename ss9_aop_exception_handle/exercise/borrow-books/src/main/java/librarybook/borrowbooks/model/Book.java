package librarybook.borrowbooks.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity;


    @JsonBackReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<CodeBook> codeBooks;

    public Book(Integer id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Set<CodeBook> getCodeBooks() {
        return codeBooks;
    }

    public void setCodeBooks(Set<CodeBook> codeBooks) {
        this.codeBooks = codeBooks;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
