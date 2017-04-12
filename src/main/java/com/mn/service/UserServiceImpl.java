package com.mn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mn.dao.UserDao;

import com.mn.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s nie istnieje w bazie!", email));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
    
	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
		
	}

	@Override
	public User findOne(Long id) {
		return userDao.findOne(id);
	}
	
}
