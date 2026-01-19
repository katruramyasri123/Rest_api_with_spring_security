package com.telusko.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.telusko.springsecurity.entities.User;
import com.telusko.springsecurity.entities.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.springsecurity.repository.UserRepo;
@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUsername(username);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		else {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
		}
		return new UserPrincipal(user);
		
		
	}

}
