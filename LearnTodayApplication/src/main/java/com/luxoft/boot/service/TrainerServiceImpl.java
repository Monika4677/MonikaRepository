package com.luxoft.boot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.luxoft.boot.entity.Trainer;
import com.luxoft.boot.exception.ResourceNotFound;
import com.luxoft.boot.model.AuthData;
import com.luxoft.boot.model.TrainerModel;
import com.luxoft.boot.repository.TrainerRepository;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired
	private TrainerRepository trainerRepository;

	@Override
	public TrainerModel trainerSignUp(TrainerModel trainerModel) {
		Trainer trainer=new Trainer(); 
		TrainerModel model=new TrainerModel();
		BeanUtils.copyProperties(trainerModel, trainer);
		Trainer trainerSignUp	=trainerRepository.save(trainer);
		BeanUtils.copyProperties(trainerSignUp, model);
		return model ;
	}

	@Override
	public TrainerModel updatePassword(AuthData auth,Integer trainerId) {
		Trainer updatedTrainer=null;
		if(null!=auth.getEmailId()) {
			
			Trainer trainer=trainerRepository.findByEmail(auth.getEmailId());
			if(null!=trainer) {
				trainer.setPassword(auth.getPassword());
				updatedTrainer=trainerRepository.save(trainer);
			}
		}
		if(null!=updatedTrainer) {
			TrainerModel model=new TrainerModel();
			BeanUtils.copyProperties(updatedTrainer, model);
		return model;
		}else {
			throw new ResourceNotFound("Searched Data not Found");
		}
	}

	

}
