package com.nazmul_anik.book_library.book_library.controller;

import com.nazmul_anik.book_library.book_library.model.BookModel;
import com.nazmul_anik.book_library.book_library.repository.LibraryRepository;
import com.nazmul_anik.book_library.book_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    LibraryRepository repository;
    @Autowired
    BookService service;

    @GetMapping("/welcome")
    public String message(){
        return "Welcome, to my Book Library !!";
    }
    // add book details
    @PostMapping("/add")
    public BookModel addBook(@RequestBody BookModel bookModel) {
        repository.save(bookModel);
        return service.addBook(bookModel);
    }
    // get Book by id
    @GetMapping("/get/byId/{id}")
    public BookModel getBook(@PathVariable Integer id){
        return service.getBook(id);
    }
    // get all book
    @GetMapping("/get/all")
    public Optional<List<BookModel>> getAllBook(){
        return service.getAllBook();
    }

    // delete book
    @DeleteMapping("/delete/byId/{id}")
    public String deleteBookById(@PathVariable Integer id){
        return service.deleteById(id);
    }
    // update book
    @PutMapping("/update/byId/{id}")
    public String updateBook(@PathVariable Integer id, @RequestBody BookModel model){
        return service.updateBookById(id, model);
    }

    // get book by name
    @GetMapping("/get/byName/{name}")
    public BookModel getBookByName(@PathVariable String name){
        return service.getBookByName(name);
    }

    @GetMapping("/get/byType/{type}")
    public Optional<List<BookModel>> getBookByType(@PathVariable String type){
        return service.getBookByType(type);
    }
}
