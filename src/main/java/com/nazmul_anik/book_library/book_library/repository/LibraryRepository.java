package com.nazmul_anik.book_library.book_library.repository;

import com.nazmul_anik.book_library.book_library.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<BookModel, Integer> {
    Optional<BookModel> findByName(String name);

    Optional<List<BookModel>> findByType(String type);

    //Optional<List<BookModel>> getBookByType(String type);
}
