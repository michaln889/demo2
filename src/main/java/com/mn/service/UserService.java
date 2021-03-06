package com.mn.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mn.entity.User;

public interface UserService extends UserDetailsService {
	void save(User user);
	User findByEmail(String email);
	List<User> findAll();
	void delete(Long id);
	User findOne(Long id);
	
}
