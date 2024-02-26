package com.example.security.Service;

import com.example.security.Model.Book;
import com.example.security.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    public Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public boolean deleteBookById(long id) {
        return bookRepository.findAll().remove(id);
    }
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
