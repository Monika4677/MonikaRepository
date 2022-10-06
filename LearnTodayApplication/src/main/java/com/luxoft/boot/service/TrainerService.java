package com.luxoft.boot.service;

import com.luxoft.boot.model.AuthData;
import com.luxoft.boot.model.TrainerModel;

public interface TrainerService {
	
	public TrainerModel trainerSignUp(TrainerModel trainerModel);
		
	public TrainerModel updatePassword ( AuthData auth,Integer trainerId);

}
