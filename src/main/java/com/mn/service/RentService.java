package com.mn.service;


import java.util.List;

import com.mn.entity.Book;
import com.mn.entity.Rent;
import com.mn.entity.User;

public interface RentService {

    void createRent(User user, Book book);
    List<Rent> findByUserOrderByCreatedDateDesc(User user);
    List<Rent> findAll();
}
