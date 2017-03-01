package com.prokarma.health.dao;

import java.util.List;

 

import com.prokarma.health.domain.LoginUser;

public interface IPKHealthDao {

	 
	 List<LoginUser> findAll();
	LoginUser findByUserId(String userId);
	void saveValidicUserDetails(LoginUser loginUser);
	 
}
