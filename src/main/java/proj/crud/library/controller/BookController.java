package proj.crud.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.crud.library.dto.book.CreateBookDto;
import proj.crud.library.dto.book.UpdateBookDto;
import proj.crud.library.entity.Book;
import proj.crud.library.service.BookService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDto createBookDto){
        var bookId = bookService.createBook(createBookDto);

        return ResponseEntity.created(URI.create("/api/books" + bookId.toString())).build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") String bookId){
        var book = bookService.getBookById(bookId);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks(){
        var books = bookService.listBooks();
        return ResponseEntity.ok(books);
    }

//    @PutMapping("/{bookId}")
//    public ResponseEntity<Book> updateById(@PathVariable("bookId") String id, UpdateBookDto updateBookDto){
//        bookService.updateBookById(id, updateBookDto);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("bookId") String bookId){
        bookService.deleteUserById(bookId);
        return ResponseEntity.ok().build();
    }
}
