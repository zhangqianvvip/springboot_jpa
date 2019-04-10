package com.example.demo.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	@Query("select u from User u where u.tuid=:tuid")
	public User findOneUser(@Param("tuid")int tuid);
	@Modifying
	@Query("update User u set u.username=:username where u.tuid=:tuid")
	public void updateUser(@Param("username")String username,@Param("tuid")int tuid);
	
	public List<User> findByPasswordOrderByTuidDesc(@Param("password")String password);
}
