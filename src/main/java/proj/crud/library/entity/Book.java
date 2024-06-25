package proj.crud.library.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;

    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "is_avaliable")
    private boolean isAvaliable;

    @CreationTimestamp
    private Instant creationTimestamp;
    @UpdateTimestamp
    private Instant updateTimestamp;

    public Book() {
    }

    public Book(UUID id, String name, String author, String publisher, boolean isAvaliable) {
        bookId = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isAvaliable = isAvaliable;
    }
}
