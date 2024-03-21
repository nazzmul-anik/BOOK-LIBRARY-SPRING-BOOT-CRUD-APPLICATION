package com.nazmul_anik.book_library.book_library.service;

import com.nazmul_anik.book_library.book_library.model.BookModel;
import com.nazmul_anik.book_library.book_library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    List<BookModel> list = new ArrayList<BookModel>();
    @Autowired
    LibraryRepository repository;

    // add book
    public BookModel addBook(BookModel model){
        list.add(model);
        return model;
    }
    // get book by id
    public BookModel getBook(Integer id){

        Optional<BookModel> book = repository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    // get All books
    public Optional<List<BookModel>> getAllBook(){
        Optional<List<BookModel>> booklist = Optional.of(repository.findAll());
        return booklist;
    }

    // delete by id
    public String deleteById(Integer id){

        Optional<BookModel> book = repository.findById(id);
        if(book.isPresent()){
            repository.deleteById(id);
            return "Delete Successfully !!";
        }

        return "Can't Find id : "+id;
    }

    // update book by id
    public String updateBookById(Integer id, BookModel model){

        Optional<BookModel> book = repository.findById(id);
        if(book.isPresent()){
            model.setId(book.get().getId());
            repository.save(model);

            return "Update Successfully By id : "+ id;
        }
        return "Can't find id : "+id;
    }

    public BookModel getBookByName(String name){
        Optional<BookModel> book = repository.findByName(name);
        if(book.isPresent()){
            return book.get();
        }

        return null;
    }

    public Optional<List<BookModel>> getBookByType(String type){
        Optional<List<BookModel>> list = repository.findByType(type);
        if(list.isPresent()&& list.get().size()>0){
            return list;
        }
        return null;
    }
}
