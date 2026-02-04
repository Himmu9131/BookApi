package com.example.BookApi.controller;

import com.example.BookApi.dto.BookRequest;
import com.example.BookApi.dto.BookResponse;
import com.example.BookApi.model.Book;
import com.example.BookApi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest){
       Book book=bookService.addBook(bookRequest);

       BookResponse response=new BookResponse(
               book.getId(),
               book.getName(),
               book.getAuthor(),
               book.getGenre(),
               book.getDescription()
       );

      return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {

        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        BookResponse response = new BookResponse(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getDescription()
        );

        return ResponseEntity.ok(response);
    }
}
