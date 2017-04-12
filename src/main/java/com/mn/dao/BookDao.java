package com.mn.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mn.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
	Collection<Book> findByTitle(String title);
}
