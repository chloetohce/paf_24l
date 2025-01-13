package paf.lecture.paf_24l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.lecture.paf_24l.model.Book;
import paf.lecture.paf_24l.repository.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(repository.getAllBooks());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(repository.getBookById(Integer.parseInt(id)));
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createBook(@RequestBody Book book) {
        Boolean bCreated = repository.insertBook(book);
        
        return ResponseEntity.ok().body(bCreated);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        Boolean bUpdated = repository.updateBook(book);
        
        return ResponseEntity.ok().body(bUpdated);
    }
    
    
}
