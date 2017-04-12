package com.mn.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mn.dao.BookDao;
import com.mn.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	 
	@Autowired
	 private BookDao bookDao;
	 

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);
		
	}

	@Override
	public void delete(Long id) {
		bookDao.delete(id);
		
	}

	@Override
	public Collection<Book> findByTitle(String title) 
	{
		Collection<Book> findedByTitle = bookDao.findByTitle(title);
		return findedByTitle;
	}
	 
	 
}
