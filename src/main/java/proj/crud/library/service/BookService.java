package proj.crud.library.service;

import org.springframework.stereotype.Service;
import proj.crud.library.dto.book.CreateBookDto;
import proj.crud.library.dto.book.UpdateBookDto;
import proj.crud.library.entity.Book;
import proj.crud.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public UUID createBook(CreateBookDto createBookDto){
        var entity = new Book(UUID.randomUUID(),
                createBookDto.name(),
                createBookDto.author(),
                createBookDto.publisher(),
                true);
        var bookSaved = bookRepository.save(entity);
        return bookSaved.getBookId();
    }

    public Optional<Book> getBookById(String bookId){
        return bookRepository.findById(UUID.fromString(bookId));
    }

    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public void updateBookById(String bookId, UpdateBookDto updateBookDto){
        var id = UUID.fromString(bookId);
        var bookEntity = bookRepository.findById(id);
        if(bookEntity.isPresent()){
            var book = bookEntity.get();
            book.setAvaliable(updateBookDto.isAvaliable());

            bookRepository.save(book);
        }
    }

    public void deleteUserById(String bookId){
        var id = UUID.fromString(bookId);
        var bookExists = bookRepository.existsById(id);
        if (bookExists){
            bookRepository.deleteById(id);
        }
    }
}
