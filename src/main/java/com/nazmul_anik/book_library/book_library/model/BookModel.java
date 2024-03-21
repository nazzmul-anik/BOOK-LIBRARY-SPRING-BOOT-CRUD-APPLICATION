package com.nazmul_anik.book_library.book_library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookModel {
    @Id
    private Integer id;
    private String name;
    private String author;
    private String type;
    private Integer page;

    // No Argument Constructor
    public BookModel(){
        super();
    }
    // All Argument Constructor
    public BookModel(Integer id, String name, String author, String type, Integer page){
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.page = page;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setPage(Integer page){
        this.page = page;
    }
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getType(){
        return type;
    }
    public Integer getPage(){
        return page;
    }


}
