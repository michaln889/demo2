package com.mn.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mn.entity.User;
import com.mn.service.EmailService;
import com.mn.service.UserService;

@Service
public class AdvService 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	//@Scheduled(fixedDelay=20000) //send every 20 sec
	@Scheduled(cron="0 41 13 * * *") //send in every day of week at 13:41:00 
	public void demoServiceMethod()
	{
		List<User> users = userService.findAll();
		
		if(users == null) //do nothing when list of users is empty
		{
			return;
		}
		
		for(User el : users)
		{
			emailService.sendEmail("dowolnaNazwaNadawcaItakBedzieTenZconfigu", el.getEmail(), "Spamujaca wiadomosc", "Nasz serwis jest najlepszy");
		}
		
		
	}
	
	
}
