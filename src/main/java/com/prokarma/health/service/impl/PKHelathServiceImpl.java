package com.prokarma.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prokarma.health.dao.IPKHealthDao;
import com.prokarma.health.domain.LoginUser;
import com.prokarma.health.domain.Post;
import com.prokarma.health.service.IPKHealthService;

@Service
public class PKHelathServiceImpl implements IPKHealthService{
	@Autowired
	private  IPKHealthDao pkhealthDao;
	
	public void isAuthorize(LoginUser loginUser) {
		LoginUser lu = pkhealthDao.findByUserId(loginUser.getUserId());
		
		if(lu != null && lu.getPassword().equals(loginUser.getPassword()))
		{
			System.out.println(lu.getId()+" : "+lu.getUserId()+" , "+lu.getPassword());
			loginUser.setAuthorized(true);
			if(lu.hasValidicUserAccessToken())
			{
				loginUser.setRegisterWithValidic(true);
				loginUser.setValidicOrganizationAccessToken(lu.getValidicOrganizationAccessToken());
				loginUser.setValidicUserAccessToken(lu.getValidicUserAccessToken());
				loginUser.setValidicUserId(lu.getValidicUserId());
			}
		}
		
		
		
	}

	 

	public void displayUsers()
	{
		pkhealthDao.findAll();
	}

	public LoginUser getUserDetails(LoginUser loginUser)
	{
		return pkhealthDao.findByUserId(loginUser.getUserId());
	}


	@Override
	public void registerWithValidic(LoginUser loginUser) {
		// Call Validic Service here
		RestTemplate rt = new RestTemplate();
		 System.out.println("Testing getUser API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        
	  //   
	    //    System.out.println(user);
	        Post user = restTemplate.getForObject("http://localhost:8888/springbootpoc/rest/post/2", Post.class);
	        System.out.println(user);
		loginUser.setValidicUserId("589a415625b9038e510004a6");
		loginUser.setValidicUserAccessToken("9baeabf46bb3c447a7a9916f059b54df071c76ede725246556d3b55e6bb9bf32");
		pkhealthDao.saveValidicUserDetails(loginUser);
	}
}
	
	 
