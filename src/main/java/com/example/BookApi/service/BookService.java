package com.example.BookApi.service;

import com.example.BookApi.dto.BookRequest;
import com.example.BookApi.exception.BookNotFoundException;
import com.example.BookApi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books=new ArrayList<>();
    private Long currentId= 1L;

    // Add a new book
    public Book addBook(BookRequest bookRequest) {

        Book book = new Book();
        book.setId(currentId++);
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setGenre(bookRequest.getGenre());
        book.setDescription(bookRequest.getDescription());

        books.add(book);
        return book;
    }

    // Get book by ID (throws exception)
    public Book getBookById(Long id) {

        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        throw new BookNotFoundException(id);
    }
}



