package com.prokarma.health.service.impl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prokarma.health.domain.LoginUser;
import com.prokarma.health.service.IValidicService;
import com.prokarma.health.utils.DateUtils;

@Service
public class ValidicServiceImpl implements IValidicService {

	
	@Override
	public String getFitnessDetails(LoginUser loginUser)   {
		
		System.out.println("Test");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, -24);
		String yesterdayDate = DateUtils.getDateInValidicFormat(c.getTime());
		String now = DateUtils.getDateInValidicFormat(new Date());
		 
				
		final String uri = "https://api.validic.com/v1/organizations/"+loginUser.getOrganizationId()+"/users/"+loginUser.getValidicUserId()+"/"
				+ "fitness.json?access_token="+loginUser.getValidicOrganizationAccessToken()
				+ "&start_date="+yesterdayDate+"&end_date="+now+"limit=200";
	     System.out.println(uri);
		 return callRestService(uri);
	}

	@Override
	public String getSleepDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String callRestService(String url)
	{
		 
	     
		   RestTemplate restTemplate = new RestTemplate();
		  String result =  restTemplate.getForObject(url, String.class);
		 
		    System.out.println(result);
		    return result;
	}

}
