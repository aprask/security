package com.example.security.Controller;

import com.example.security.Model.Book;
import com.example.security.Model.CD;
import com.example.security.Model.DVD;
import com.example.security.Model.ItemErrorResponse;
import com.example.security.Service.BookService;
import com.example.security.Service.CDService;
import com.example.security.Service.DVDService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Data
public class ItemController {
    private final BookService bookService;
    private final CDService cdService;
    private final DVDService dvdService;
    @Autowired
    public ItemController(BookService bookService, CDService cdService, DVDService dvdService) {
        this.bookService = bookService;
        this.cdService = cdService;
        this.dvdService = dvdService;
    }
    @GetMapping("/getAllBooks")
    public String getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return null;
    }
    @GetMapping("/getAllCDs")
    public List<CD> getAllCDs() {
        return cdService.findAllCDs();
    }
    @GetMapping("/getAllDVDs")
    public List<DVD> getAllDVDs() {
        return dvdService.findAllDVDs();
    }
    @GetMapping("/findBookById")
    public Book findBookById(long id) {
        return bookService.findBookById(id);
    }
    @GetMapping("/deleteBookById")
    public boolean deleteBookById(long id) {
        return bookService.deleteBookById(id);
    }
    @GetMapping("/createBook")
    public void createBook(Book book) {
        bookService.createBook(book);
    }
    @GetMapping("findCDById")
    public CD findCDById(long id) {
        return cdService.findBookById(id);
    }
    @GetMapping("/deleteCDById")
    public boolean deleteCDById(long id) {
        return cdService.deleteBookById(id);
    }
    @GetMapping("/createCD")
    public void createCD(CD cd) {
        cdService.createCD(cd);
    }
    @GetMapping("/findDVDById/{id}")
    public DVD findDVDById(@PathVariable long id) {
        if(dvdService.findBookById(id) == null
                || id > dvdService.findAllDVDs().size() || id < 0)
        {
            throw new RuntimeException("DVD not found -- " + id);
        }
        return dvdService.findBookById(id);
    }
    @GetMapping("/deleteDVDById")
    public boolean deleteDVDById(long id) {
        return dvdService.deleteBookById(id);
    }
    @GetMapping("/createDVD")
    public void createDVD(DVD dvd) {
        dvdService.createDVD(dvd);
    }

    @ExceptionHandler
    public ResponseEntity<ItemErrorResponse> handleException(Exception ex) {
        ItemErrorResponse error = new ItemErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
