package com.prokarma.health.service;

import com.prokarma.health.domain.LoginUser;

public interface IValidicService {
      String getFitnessDetails(LoginUser loginUser);
      String getSleepDetails();      
}
