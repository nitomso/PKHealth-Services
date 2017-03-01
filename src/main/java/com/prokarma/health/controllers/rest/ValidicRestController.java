package com.prokarma.health.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.prokarma.health.domain.LoginUser;
import com.prokarma.health.service.IPKHealthService;
import com.prokarma.health.service.IValidicService;


@RestController
public class ValidicRestController {
 
	
	@Autowired
	private IPKHealthService pkHealthService;
	
	@Autowired
	private IValidicService validicService;
	
	
	@RequestMapping(value="pkhealth/rest/loginService",
					method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginUser> authorizeUsers(@RequestBody LoginUser  loginUser)
	{
		 pkHealthService.isAuthorize(loginUser);
		 loginUser.isAuthorized();
		 pkHealthService.displayUsers();
		 return new ResponseEntity<LoginUser>(loginUser,HttpStatus.ACCEPTED);
	}
	
	
	
	@RequestMapping(value="pkhealth/rest/registerWithValidic",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<LoginUser> registerWithValidic(@RequestBody LoginUser  loginUser)
{
		if(loginUser.isAuthorized() && !loginUser.isRegisterWithValidic())
		{
			pkHealthService.registerWithValidic(loginUser);
		}
	 
	 return new ResponseEntity<LoginUser>(loginUser,HttpStatus.ACCEPTED);
}
	
	@RequestMapping(value="pkhealth/rest/fitnessService",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> getFitnessDetails(@RequestBody LoginUser  loginUser)
{
		pkHealthService.isAuthorize(loginUser);
		
		if(loginUser.isAuthorized() && loginUser.isRegisterWithValidic())
		{
		//	loginUser.setValidicUserId("589a415625b9038e510004a6");
			//loginUser.setValidicUserAccessToken("dR4g_qjhNJ5SYtzmxZ1L");
			loginUser.setValidicOrganizationAccessToken("9baeabf46bb3c447a7a9916f059b54df071c76ede725246556d3b55e6bb9bf32");
			loginUser.setOrganizationId("5886781fff9d930008000050");
			return new ResponseEntity<String>( validicService.getFitnessDetails(loginUser),HttpStatus.OK);		 
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
}
 
}
