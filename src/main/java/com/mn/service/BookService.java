package com.mn.service;

import java.util.Collection;
import java.util.List;

import com.mn.entity.Book;

public interface BookService {
	List<Book> findAll();
	Book findOne(Long id);
	void save(Book book);
	void delete(Long id);
	
	
	Collection<Book> findByTitle(String title);
		
}
