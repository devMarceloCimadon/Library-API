package proj.crud.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.crud.library.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
