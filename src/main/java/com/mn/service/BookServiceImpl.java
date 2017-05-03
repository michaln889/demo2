package com.mn.service;

import java.util.ArrayList;
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
	public Collection<Book> findByTitleOrAuthor(String title, String author) 
	{
		Collection<Book> allBooks = bookDao.findAll();
		Collection<Book> findedBooks = new ArrayList<>();
		
		if(title == "" && author == "")
		{
			findedBooks = null;
		}
		else if(title == "")
		{
			for(Book el : allBooks)
			{
				if(el.getAuthor().toLowerCase().contains(author.toLowerCase()))
				{
					findedBooks.add(el);
				}
			}
		}
		else if(author == "")
		{
			for(Book el : allBooks)
			{
				if(el.getTitle().toLowerCase().contains(title.toLowerCase()))
				{
					findedBooks.add(el);
				}
				
			}
		}
		else 
		{
			for(Book el : allBooks)
			{
				if(el.getTitle().toLowerCase().contains(title.toLowerCase()) && el.getAuthor().toLowerCase().contains(author.toLowerCase()))
				{
					findedBooks.add(el);
				}
			}
		}
		return findedBooks;
	}
	 
	 
}
