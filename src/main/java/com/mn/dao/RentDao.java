package com.mn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mn.entity.Rent;
import com.mn.entity.User;

@Repository
public interface RentDao extends JpaRepository<Rent, Long> {

    List<Rent> findByUserOrderByCreatedDateDesc(User user);

}
