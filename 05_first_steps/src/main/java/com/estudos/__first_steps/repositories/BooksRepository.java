package com.estudos.__first_steps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.__first_steps.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{
}
