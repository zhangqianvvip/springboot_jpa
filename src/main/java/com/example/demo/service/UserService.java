package com.example.demo.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Transactional()
	public void saveUser(User user) {
		System.out.println("ok"+userRepository.saveAndFlush(user));
	
		
	}
	@Transactional()
	public User findOneUser(int id) {
		return userRepository.findOneUser(id);
	}
	@Transactional()
	public void updateUser(int id,String name) {
		 userRepository.updateUser(name, id);
		
	}
	@Transactional
	public List<User> findByPassword(String password){
		return userRepository.findByPasswordOrderByTuidDesc(password);
	}
}
