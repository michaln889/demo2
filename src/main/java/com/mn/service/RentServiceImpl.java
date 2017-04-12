package com.mn.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mn.dao.BookDao;
import com.mn.dao.RentDao;
import com.mn.entity.Book;
import com.mn.entity.Rent;
import com.mn.entity.User;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public void createRent(User user, Book book) {
        Rent rent = new Rent(user, book);

        rentDao.save(rent);
        book.setAvailable(book.getAvailable()-1);
        bookDao.save(book);
    }
    
    public List<Rent> findByUserOrderByCreatedDateDesc(User user) {
    	return rentDao.findByUserOrderByCreatedDateDesc(user);
    }

	@Override
	public List<Rent> findAll() {
		return rentDao.findAll();
	}
}
