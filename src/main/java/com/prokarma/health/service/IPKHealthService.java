package com.prokarma.health.service;

import java.util.Collection;

 
import com.prokarma.health.domain.LoginUser;

public interface IPKHealthService {
	 void isAuthorize(LoginUser loginUser);
	 void displayUsers();
	void registerWithValidic(LoginUser loginUser);
	 
	 
}
