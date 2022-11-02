package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String mailId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByMailID(mailId);
		if(user == null) {
			throw new UsernameNotFoundException("User 404 not found");
		}
		ControllerClass.user = user;
		//System.out.println(cc.name);
		return new UserPrinciple(user);
	}


}
